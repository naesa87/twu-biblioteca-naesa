package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieCollectionTest {
    private MovieCollection movieCollection = new MovieCollection();
    private Movie availableMovie = new Movie("Fight Club","David Fincher",1999, 8);
    private Movie availableMovie2 = new Movie("Mean Girls","Mark Waters",2004,9);
    private Movie checkedOutMovie = new Movie("The Breakfast Club","John Hughes",1985, 10, "123-1235");
    private Movie notFoundMovie = new Movie("Before Sunset", "Richard Linklater", 2004, 9, "123-1234");
    private String userID = "123-1234";

    @Test
    public void testContainsBook() throws Exception {
        assertTrue("ContainsBook should be true", movieCollection.containsItem(availableMovie.name()));
        assertFalse("ContainsBook should be false", movieCollection.containsItem(notFoundMovie.name()));
    }

    @Test
    public void testIsBookAvailable(){
        assertTrue("IsBookAvailable should be true", movieCollection.isItemAvailable(availableMovie.name()));
        assertFalse("IsBookAvailable should be false", movieCollection.isItemAvailable(checkedOutMovie.name()));
    }

    @Test
    public void testGetBook() throws Exception {
        Movie retrievedMovie = movieCollection.getItem(availableMovie.name());
        assertEquals("Incorrect book", availableMovie, retrievedMovie);
    }


    @Test
    public void testCheckOutBook() throws Exception {
        assertEquals("Book does not exist in library", movieCollection.checkOutItem(notFoundMovie.name(), userID));
        assertEquals("Book is currently unavailable for checkout", movieCollection.checkOutItem(checkedOutMovie.name(), userID));
        assertEquals("Thank you! Enjoy the book", movieCollection.checkOutItem(availableMovie.name(), userID));

        Movie checkedOutmovie = movieCollection.getItem(availableMovie.name());
        assertEquals("Incorrect checkout",userID, checkedOutmovie.userID());
    }

    @Test
    public void testReturnBook() throws Exception {
        assertEquals("Book does not exist in library", movieCollection.returnItem(notFoundMovie.name()));
        assertEquals("Book has already been returned", movieCollection.returnItem(availableMovie2.name()));
        assertEquals("Thank you for returning the book", movieCollection.returnItem(checkedOutMovie.name()));

        Movie returnedMovie = movieCollection.getItem(checkedOutMovie.name());
        assertEquals("Incorrect return", null, returnedMovie.userID());
    }

    @Test
    public void testGetBookListCheckedOut() throws Exception{
        String expectedString =
                        "============================================================================================================\n" +
                        "LIST OF MOVIES\n" +
                        "NAME                                     AUTHOR                         RATING                YEAR\n" +
                        "The Godfather                            Francis Ford Coppola           10                    1972\n" +
                        "The Breakfast Club                       John Hughes                    10                    1985\n" +
                        "============================================================================================================";
        assertEquals("Incorrect list", expectedString, movieCollection.getLibraryCollection(false));
    }

    @Test
    public void testGetBookListAvailable() throws Exception{
        String expectedString =
                        "============================================================================================================\n" +
                        "LIST OF MOVIES\n" +
                        "NAME                                     AUTHOR                         RATING                YEAR\n" +
                        "Eternal Sunshine of the Spotless Mind    Michel Gondry                  9                     2004\n" +
                        "Fight Club                               David Fincher                  8                     1999\n" +
                        "Mean Girls                               Mark Waters                    9                     2004\n" +
                        "============================================================================================================";
        assertEquals("Incorrect list", expectedString, movieCollection.getLibraryCollection(true));
    }
}
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
    public void testContainsMovie() throws Exception {
        assertTrue("ContainsMovie should be true", movieCollection.containsItem(availableMovie.getName()));
        assertFalse("ContainsMovie should be false", movieCollection.containsItem(notFoundMovie.getName()));
    }

    @Test
    public void testIsMovieAvailable(){
        assertTrue("IsMovieAvailable should be true", movieCollection.isItemAvailable(availableMovie.getName()));
        assertFalse("IsMovieAvailable should be false", movieCollection.isItemAvailable(checkedOutMovie.getName()));
    }

    @Test
    public void testGetMovie() throws Exception {
        Movie retrievedMovie = movieCollection.getItem(availableMovie.getName());
        assertEquals("Incorrect movie", availableMovie, retrievedMovie);
    }


    @Test
    public void testCheckOutMovie() throws Exception {
        assertEquals("[ Movie does not exist in library ]", movieCollection.checkOutItem(notFoundMovie.getName(), userID));
        assertEquals("[ Movie is currently unavailable for checkout ]", movieCollection.checkOutItem(checkedOutMovie.getName(), userID));
        assertEquals("Thank you! Enjoy the movie", movieCollection.checkOutItem(availableMovie.getName(), userID));

        Movie checkedOutmovie = movieCollection.getItem(availableMovie.getName());
        assertEquals("Incorrect checkout",userID, checkedOutmovie.getUserID());
    }

    @Test
    public void testReturnMovie() throws Exception {
        assertEquals("[ Movie does not exist in library ]", movieCollection.returnItem(notFoundMovie.getName()));
        assertEquals("[ Movie has already been returned ]", movieCollection.returnItem(availableMovie2.getName()));
        assertEquals("Thank you for returning the movie", movieCollection.returnItem(checkedOutMovie.getName()));

        Movie returnedMovie = movieCollection.getItem(checkedOutMovie.getName());
        assertEquals("Incorrect return", null, returnedMovie.getUserID());
    }

    @Test
    public void testGetMovieListCheckedOut() throws Exception{
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
    public void testGetMovieListAvailable() throws Exception{
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
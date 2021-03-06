package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidMovieException;
import com.twu.biblioteca.models.exceptions.InvalidUserException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private String expectedName = "The Godfather";
    private String expectedDirector = "Francis Ford Coppola";
    private int expectedYear = 1972;
    private Integer expectedRating = 9;
    private String expectedUserID = "123-1234";
    private Movie typicalMovie = new Movie(expectedName,expectedDirector,expectedYear,expectedRating);

    @Test
    public void testTypicalMovieConstructorAndBasicGetters(){
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 9);

        assertEquals("Incorrect name", expectedName, movie.getName());
        assertEquals("Incorrect director", expectedDirector, movie.getDirector());
        assertEquals("Incorrect year", expectedYear, movie.getYear());
        assertEquals("Incorrect rating", expectedRating, movie.getRating());
    }

    @Test
    public void testMovieConstructorWithCustomerAndBasicGetters(){
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 9, "123-1234");
        assertEquals("Incorrect name", expectedName, movie.getName());
        assertEquals("Incorrect director", expectedDirector, movie.getDirector());
        assertEquals("Incorrect year", expectedYear, movie.getYear());
        assertEquals("Incorrect rating", expectedRating, movie.getRating());
        assertEquals("Incorrect userid", expectedUserID,movie.getUserID());
    }

    @Test(timeout=5000)
    public void testNullInMovieConstructor() throws Exception {
        try {
            new Movie(expectedName,null,1972,9);
            fail("NullPointerException expected");
        } catch (Exception e) {
            assertTrue("NullPointerException expected",
                    e instanceof NullPointerException);
        }
        try {
            new Movie(null,expectedDirector,1972,9);
            fail("NullPointerException expected");
        } catch (Exception e) {
            assertTrue("NullPointerException expected",
                    e instanceof NullPointerException);
        }
    }

    @Test(timeout=5000)
    public void testBadDateInMovieConstructor() throws Exception {
        try {
            new Movie(expectedName,expectedDirector,20161,9);
            fail("InvalidMovieException expected");
        } catch (Exception e) {
            assertTrue("InvalidMovieException expected",
                    e instanceof InvalidMovieException);
        }
    }

    @Test(timeout=5000)
    public void testBadRatingInMovieConstructor() throws Exception {
        try {
            new Movie(expectedName,expectedDirector,1972,-1);
            fail("InvalidMovieException expected");
        } catch (Exception e) {
            assertTrue("InvalidMovieException expected",
                    e instanceof InvalidMovieException);
        }
        try {
            new Movie(expectedName,expectedDirector,1972,11);
            fail("InvalidMovieException expected");
        } catch (Exception e) {
            assertTrue("InvalidMovieException expected",
                    e instanceof InvalidMovieException);
        }
    }


    @Test
    public void testNullRatingInMovieConstructor() throws Exception{
        Movie movie = new Movie(expectedName, expectedDirector, expectedYear, null);
        assertEquals("Incorrect rating", null, movie.getRating());
    }

    @Test
    public void testSetUserGetUser() throws Exception {
        typicalMovie.setUser("123-1234");
        assertEquals("Incorrect UserID", expectedUserID, typicalMovie.getUserID());
        typicalMovie.setUser(null);
        assertEquals("Incorrect UserID", null, typicalMovie.getUserID());
    }

    @Test(expected = InvalidUserException.class, timeout=5000)
    public void testSetUserWithWrongFormat() throws Exception {
        typicalMovie.setUser("A23-1234");
        typicalMovie.setUser("");
    }

    @Test
    public void testMovieIsCheckedOut(){
        typicalMovie.setUser(expectedUserID);
        assertEquals("IsCheckedOut should return true", true, typicalMovie.isCheckedOut());
    }
    @Test
    public void basicEqualsTest() {
        Movie sameMovie1 = new Movie(expectedName,expectedDirector,expectedYear,expectedRating);
        Movie sameMovie2 = new Movie(expectedName,expectedDirector,expectedYear,expectedRating);
        Movie diffMovie1 = new Movie(expectedName,expectedDirector,expectedYear,2);

        assertTrue("Equals should return true", sameMovie1.equals(sameMovie2));
        assertFalse("Equals should return false", sameMovie1.equals(diffMovie1));
    }

    @Test
    public void basicEqualsTestWithUserID() {
        Movie sameMovie1 = new Movie(expectedName,expectedDirector,expectedYear,expectedRating,expectedUserID);
        Movie sameMovie2 = new Movie(expectedName,expectedDirector,expectedYear,expectedRating);
        sameMovie2.setUser(expectedUserID);
        Movie diffMovie1 = new Movie(expectedName,expectedDirector,expectedYear,2,"345-3456");

        assertTrue("Equals should return true", sameMovie1.equals(sameMovie2));
        assertFalse("Equals should return false", sameMovie1.equals(diffMovie1));
    }

}
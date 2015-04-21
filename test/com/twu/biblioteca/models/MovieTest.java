package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;
import com.twu.biblioteca.models.exceptions.InvalidMovieException;
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

        assertEquals("Incorrect name", expectedName, movie.name());
        assertEquals("Incorrect director", expectedDirector, movie.director());
        assertEquals("Incorrect year", expectedYear, movie.year());
        assertEquals("Incorrect rating", expectedRating, movie.rating());
    }

    @Test
    public void testMovieConstructorWithCustomerAndBasicGetters(){
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 9, "123-1234");
        assertEquals("Incorrect name", expectedName, movie.name());
        assertEquals("Incorrect director", expectedDirector, movie.director());
        assertEquals("Incorrect year", expectedYear, movie.year());
        assertEquals("Incorrect rating", expectedRating, movie.rating());
        assertEquals("Incorrect userid", expectedUserID,movie.userID());
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
        assertEquals("Incorrect rating", null, movie.rating());
    }

    @Test
    public void testSetUserGetUser() throws Exception {
        typicalMovie.setUser("123-1234");
        assertEquals("Incorrect UserID", expectedUserID, typicalMovie.userID());
        typicalMovie.setUser(null);
        assertEquals("Incorrect UserID", null, typicalMovie.userID());
    }

    @Test(expected = InvalidMovieException.class, timeout=5000)
    public void testSetUserWithWrongFormat() throws Exception {
        typicalMovie.setUser("A23-1234");
        typicalMovie.setUser("");
    }


}
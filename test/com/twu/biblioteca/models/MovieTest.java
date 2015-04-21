package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private String expectedName = "The Godfather";
    private String expectedDirector = "Francis Ford Coppola";
    private int expectedYear = 1972;
    private int expectedRating = 9;


    @Test
    public void testTypicalBookConstructorAndBasicGetters(){
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 9);

        assertEquals("Incorrect name", expectedName, movie.name());
        assertEquals("Incorrect director", expectedDirector, movie.director());
        assertEquals("Incorrect year", expectedYear, movie.year());
        assertEquals("Incorrect rating", expectedRating, movie.rating());
    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;
import com.twu.biblioteca.models.exceptions.InvalidBookException;
import com.twu.biblioteca.models.exceptions.InvalidMovieException;

public class Movie {

    private String name;
    private String director;
    private int year;
    private int rating;
    private String libraryID;

    public Movie(String name, String director, int year, int rating){
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public void setCustomer(String libraryID){
        if (libraryID == null){
            this.libraryID = null;
            return;
        }
        if (StringHelper.isNotWhitespace(libraryID)){
            this.libraryID = libraryID;
        } else {
            throw new InvalidMovieException("Customer name must have characters");
        }
    }

    public String name(){
        return name;
    }

    public String director(){
        return director;
    }

    public int year(){
        return year;
    }

    public int rating(){
        return rating;
    }
}

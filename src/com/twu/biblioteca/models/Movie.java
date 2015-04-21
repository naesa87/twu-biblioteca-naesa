package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;
import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.exceptions.InvalidBookException;
import com.twu.biblioteca.models.exceptions.InvalidMovieException;

public class Movie {

    private String name;
    private String director;
    private int year;
    private int rating;
    private String userID;

    public Movie(String name, String director, int year, int rating){
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public void setUser(String userID){
        if (userID == null){
            this.userID = null;
            return;
        }
        if (ValidationHelper.isValidUserID(userID)){
            this.userID = userID;
        } else {
            throw new InvalidMovieException("User library number must have format XXX-XXXX");
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

    public String userID(){
        return userID;
    }
}

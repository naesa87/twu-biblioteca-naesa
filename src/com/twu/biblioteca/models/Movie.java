package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.exceptions.InvalidMovieException;

public class Movie {

    private String name;
    private String director;
    private int year;
    private Integer rating;
    private String userID;

    public Movie(String name, String director, int year, Integer rating){
        if(name == null || director == null ){
            throw new NullPointerException(
                    "Parameters for movie cannot be null");
        } else if (!ValidationHelper.isValidYear(year)) {
            throw new InvalidMovieException("Year needs to be greater than 0 and less than today's year");
        } else if (!ValidationHelper.isValidRating(rating)) {
            throw new InvalidMovieException("Rating needs to be from 1 to 10");
        }
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Movie(String name, String director, int year, Integer rating, String userID){
        this(name, director, year, rating);
        setUser(userID);
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

    public Integer rating(){
        return rating;
    }

    public String userID(){
        return userID;
    }

    public boolean isCheckedOut(){
        return userID != null;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) object;
        if (userID == null) {
            if (movie.userID != null)
                return false;
        } else if (!userID.equals(movie.userID)) {
            return false;
        }
        if (rating == null) {
            if (movie.rating != null)
                return false;
        } else if (!rating.equals(movie.rating)) {
            return false;
        }
        return (name.equals(movie.name)
                && director.equals(movie.director)
                && year == (movie.year));
    }

    @Override
    public int hashCode() {
        final int prime = 31; // a prime for combining hash codes of fields
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + director.hashCode();
        if (userID != null){
            result = prime * result + userID.hashCode();
        }
        if (rating != null){
            result = prime * result + rating.hashCode();
        }
        result = prime * result + year;
        return result;
    }

}

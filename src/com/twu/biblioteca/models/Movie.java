package com.twu.biblioteca.models;

public class Movie {

    private String name;
    private String director;
    private int year;
    private int rating;

    public Movie(String name, String director, int year, int rating){
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
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

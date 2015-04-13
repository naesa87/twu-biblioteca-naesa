package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;

import java.util.Calendar;

public class Book {

    private String name;
    private String author;
    private int year;
    private String customer;

    public Book(String name, String author, int year){
        if(name == null || author == null ){
            throw new NullPointerException(
                    "Parameters for book cannot be null");
        } else if (year < 0 || year >= Calendar.getInstance().get(Calendar.YEAR)) {
            throw new InvalidBookException("Year needs to be greater than 0 and less than today's year");
        }
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void setCustomer(String customer){
        if (isNotWhitespace(customer)){
            this.customer = customer;
        } else {
            throw new InvalidBookException("Customer name must have characters");
        }
    }

    private boolean isNotWhitespace(String string) {
        return string.trim().length() > 0;
    }

    public String name(){
        return name;
    }

    public String author(){
        return author;
    }

    public int year(){
        return year;
    }
    public boolean isCheckedOut(){
        return customer != null;
    }

    public String customer(){
        return customer;
    }
}
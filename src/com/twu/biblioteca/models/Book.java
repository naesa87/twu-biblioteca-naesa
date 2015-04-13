package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;
import com.twu.biblioteca.helpers.StringHelper;
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
        } else if (isValidYear(year)) {
            throw new InvalidBookException("Year needs to be greater than 0 and less than today's year");
        }
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void setCustomer(String customer){
        if (StringHelper.isNotWhitespace(customer)){
            this.customer = customer;
        } else {
            throw new InvalidBookException("Customer name must have characters");
        }
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

    public String customer(){
        return customer;
    }

    public boolean isCheckedOut(){
        return customer != null;
    }

    private boolean isValidYear(int year) {
        return year < 0 || year >= Calendar.getInstance().get(Calendar.YEAR);
    }

}
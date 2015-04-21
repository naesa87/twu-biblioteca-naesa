package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ValidationHelper;
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
        } else if (!ValidationHelper.isValidYear(year)) {
            throw new InvalidBookException("Year needs to be greater than 0 and less than today's year");
        }
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void setCustomer(String customer){
        if (customer == null){
            this.customer = null;
            return;
        }
        if (StringHelper.isNotWhitespace(customer)){
            this.customer = customer;
        } else {
            throw new InvalidBookException("Customer name must have characters");
        }
    }

    public Book(String name, String author, int year, String customer){
        this(name,author,year);
        setCustomer(customer);
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

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) {
            return false;
        }
        Book book = (Book) object;
        if (customer == null) {
            if (book.customer != null)
                return false;
        } else if (!customer.equals(book.customer)) {
            return false;
        }
        return (name.equals(book.name)
                && author.equals(book.author)
                && year == (book.year));
    }

    @Override
    public int hashCode() {
        final int prime = 31; // a prime for combining hash codes of fields
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + author.hashCode();
        if (customer != null){
            result = prime * result + customer.hashCode();
        }
        result = prime * result + year;
        return result;
    }

    @Override
    public String toString() {
        String availableFlag = isCheckedOut() ? "available" : "checked out";
        return (name() + " by " + author() + " (" + year() + ") : " + availableFlag);
    }



}
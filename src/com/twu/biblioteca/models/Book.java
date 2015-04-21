package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.exceptions.InvalidBookException;

public class Book extends LibraryItem {

    private String author;

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

    public Book(String name, String author, int year, String userID){
        this(name,author,year);
        setUser(userID);
    }



    public String author(){
        return author;
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) {
            return false;
        }
        Book book = (Book) object;
        if (userID == null) {
            if (book.userID != null)
                return false;
        } else if (!userID.equals(book.userID)) {
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
        if (userID != null){
            result = prime * result + userID.hashCode();
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
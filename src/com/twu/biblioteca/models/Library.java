package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;

    public Library(){
        this.availableBooks = new ArrayList<Book>();
        this.checkedOutBooks = new ArrayList<Book>();
    }

    public Book viewBookDetails(Book book){
        return new Book("hi","there",2000);
    }

    public void checkOutBook(Book book, Customer customer){
        // check if book in checkedoutbook , if exists --> say not available
        // check if book is in availablebooks, if exists --> checkout
                // checkout includes: remove from one list and add to another,
                // give book a customer
        // if book not exist in either --> say book not exist
        // success/unsuccess msage

    }

    public void returnBook(Book book, Customer customer){
        // success/unsuccess msage
    }

    private void removeBookFromAvailableBooks(Book book){

    }

    private void removeBookFromCheckoutBooks(Book book){

    }

    private void addBookToAvailableBooks(Book book){

    }

    private void addBookToCheckoutBooks(Book book){

    }

    public boolean containsBook(Book book){
        return true; // make equal and hash for book
    }

    public void createBook(String name, String author, int year, Customer customer ){
        Book book = new Book(name,author,year);
        // check customer null or whitespace, if not then set customer
        // if book is checkedout --> addbooktocheckout
        // if not checktou --> add book to avaliable
    }
}

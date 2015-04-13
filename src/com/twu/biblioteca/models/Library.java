package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> listOfBooks;

    public Library(){
        this.listOfBooks = new ArrayList<Book>();
    }

    public boolean containsBook(String bookName){
        return true; // make equal and hash for book
    }

    public Book getBook(String bookName){
        return new Book("sd","sd",1234);
    }

    public List<Book> getBooks(boolean checkedOutFlag){
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book: listOfBooks){
            if (book.isCheckedOut()==checkedOutFlag){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    public void checkOutBook(Book book, Customer customer){
        // check if book in listOFBooks , if not exists --> say not exists
            // check if book is checkedout --> say not available
                // otherwise checkout: give book a customer
        // success/unsuccess msage
    }

    public void returnBook(Book book, Customer customer){
        // success/unsuccess msage
    }


    public void createBook(String name, String author, int year, Customer customer ){
        Book book = new Book(name,author,year);
        // check customer null or whitespace, if not then set customer
        // if book is checkedout --> addbooktocheckout
        // if not checktou --> add book to avaliable
    }
}

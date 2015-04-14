package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> listOfBooks;

    public Library(){
        this.listOfBooks = new ArrayList<Book>();
        loadTempBookData(); //since there is no db yet
    }

    public boolean containsBook(String bookName){
        for(Book book: listOfBooks){
            if (bookName.equals(book.name())){
                return true;
            }
        }
        return false;
    }

    public Book getBook(String bookName){
        for(Book book: listOfBooks){
            if (bookName.equals(book.name())){
                return book;
            }
        }
        return null;
    }

    public boolean isBookAvailable(String bookName){
        Book book = getBook(bookName);
        return !book.isCheckedOut();
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


    public void checkOutBook(Book book, String customer){
        // check if book in listOFBooks , if not exists --> say not exists
            // check if book is checkedout --> say not available
                // otherwise checkout: give book a customer
        // success/unsuccess msage
    }

    public void returnBook(Book book, String customer){
        // success/unsuccess msage
    }

    /*temporary loading of book data while no database is in place and no addBook method is required */
    private void loadTempBookData(){
        listOfBooks.add(new Book("The Lord of the Rings","J.R.R. Tolkien",1954));
        listOfBooks.add(new Book("The Little Prince","Antoine de Saint-Exupéry",1943));
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997, "Jane Smith"));
        listOfBooks.add(new Book("The Catcher in the Rye","J.D. Salinger",1951, "John Doe"));
        listOfBooks.add(new Book("The Hunger Games","Suzanne Collins",2008));
    }

 /*   public void addBook(String name, String author, int year, String customer ){
       // create valid book (does own internal checks)
       // check if library already contains book (avoid duplicaation)
        // check customer null or whitespace, if not, then set customer
       // add book to library
    }*/
}

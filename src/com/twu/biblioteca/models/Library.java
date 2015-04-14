package com.twu.biblioteca.models;

import org.omg.CORBA.Environment;

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

    public String getlistOfBooks(boolean checkedOutFlag){
        StringBuilder listOfBooksString = new StringBuilder();
        String LS = System.getProperty("line.separator");
        for (Book book: listOfBooks){
            if (book.isCheckedOut()==checkedOutFlag){
                listOfBooksString.append(book);
                listOfBooksString.append(LS);
            }
        }
        return listOfBooksString.toString();
    }


    public String checkOutBook(String bookName, String customer){

        if (!containsBook(bookName)){
            return "Book does not exist in library";
        }
        if (!isBookAvailable(bookName)){
            return "Book is currently unavailable for checkout";
        }
        try {
            Book book = getBook(bookName);
            book.setCustomer(customer);
        }catch (Exception e){
            return "Book could not be checked out";
        }
        return "Thank you! Enjoy the book" ;
    }

    public String returnBook(String bookName){
        if (!containsBook(bookName)){
            return "Book does not exist in library";
        }
        if (isBookAvailable(bookName)){
            return "Book has already been returned";
        }
        try {
            Book book = getBook(bookName);
            book.setCustomer(null);
        }catch (Exception e){
            return "Book could not be returned";
        }
        return "Thank you for returning the book" ;
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

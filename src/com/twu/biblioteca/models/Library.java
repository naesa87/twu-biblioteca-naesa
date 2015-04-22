package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> listOfBooks;
    private static final String LIBRARY_TITLE = "LIST OF BOOKS";

    public Library(){
        this.listOfBooks = new ArrayList<Book>();
        loadTempBookData(); //since there is no db yet
    }

    public boolean containsBook(String bookName){
        for(Book book: listOfBooks){
            if (bookName.equalsIgnoreCase(book.name())){
                return true;
            }
        }
        return false;
    }

    public Book getBook(String bookName){
        for(Book book: listOfBooks){
            if (bookName.equalsIgnoreCase(book.name())){
                return book;
            }
        }
        return null;
    }

    public boolean isBookAvailable(String bookName){
        Book book = getBook(bookName);
        return !book.isCheckedOut();
    }

    public String getlistOfBooks(boolean availableFlag){
        StringBuilder listOfBooksString = new StringBuilder();
        String LS = System.getProperty("line.separator");
        listOfBooksString.append(StringHelper.horizontalLine());
        listOfBooksString.append(LS);
        listOfBooksString.append(LIBRARY_TITLE);
        listOfBooksString.append(LS);
        listOfBooksString.append(String.format("%-60s %-30s  %15s", "NAME", "AUTHOR", "YEAR"));
        listOfBooksString.append(LS);
        for (Book book: listOfBooks){
            if (book.isCheckedOut()!=availableFlag){
                listOfBooksString.append(
                        String.format("%-60s %-30s  %15d", book.name(), book.author(), book.year()));
                listOfBooksString.append(LS);
            }
        }
        listOfBooksString.append(StringHelper.horizontalLine());
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
            book.setUser(customer);
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
            book.setUser(null);
        }catch (Exception e){
            return "Book could not be returned";
        }
        return "Thank you for returning the book" ;
    }

    /*temporary loading of book data while no database is in place and no addBook method is required */
    private void loadTempBookData(){
        listOfBooks.add(new Book("The Lord of the Rings","J.R.R. Tolkien",1954));
        listOfBooks.add(new Book("The Little Prince","Antoine de Saint-Exupéry",1943));
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997, "123-1234"));
        listOfBooks.add(new Book("The Catcher in the Rye","J.D. Salinger",1951, "123-1235"));
        listOfBooks.add(new Book("The Hunger Games","Suzanne Collins",2008));
    }

}

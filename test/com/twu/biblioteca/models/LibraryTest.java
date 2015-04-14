package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library testLibrary = new Library();
    private Book availableBook = new Book("The Hunger Games","Suzanne Collins",2008);
    private Book availableBook2 = new Book("The Little Prince","Antoine de Saint-Exupéry",1943);
    private Book checkedOutBook = new Book("The Catcher in the Rye","J.D. Salinger",1951,"John Doe");
    private Book notFoundBook = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "John Doe");
    private String customer = "John Doe";

    @Test
    public void testContainsBook() throws Exception {
        assertTrue("ContainsBook should be true", testLibrary.containsBook(availableBook.name()));
        assertFalse("ContainsBook should be false", testLibrary.containsBook(notFoundBook.name()));
    }

    @Test
    public void testIsBookAvailable(){
        assertTrue("IsBookAvailable should be true", testLibrary.isBookAvailable(availableBook.name()));
        assertFalse("IsBookAvailable should be false", testLibrary.isBookAvailable(checkedOutBook.name()));
    }

    @Test
    public void testGetBook() throws Exception {
        Book retrievedBook = testLibrary.getBook(availableBook.name());
        assertEquals("Incorrect book", availableBook, retrievedBook);
    }


    @Test
    public void testCheckOutBook() throws Exception {
        assertEquals("Book does not exist in library", testLibrary.checkOutBook(notFoundBook.name(),customer));
        assertEquals("Book is currently unavailable for checkout", testLibrary.checkOutBook(checkedOutBook.name(),customer));
        assertEquals("Thank you! Enjoy the book", testLibrary.checkOutBook(availableBook.name(), customer));

        Book checkedOutbook = testLibrary.getBook(availableBook.name());
        assertEquals("Incorrect checkout",customer, checkedOutbook.customer());
    }

    @Test
    public void testReturnBook() throws Exception {
        assertEquals("Book does not exist in library", testLibrary.returnBook(notFoundBook.name()));
        assertEquals("Book has already been returned", testLibrary.returnBook(availableBook2.name()));
        assertEquals("Thank you for returning the book", testLibrary.returnBook(checkedOutBook.name()));

        Book returnedBook = testLibrary.getBook(checkedOutBook.name());
        assertEquals("Incorrect return", null, returnedBook.customer());
    }

    @Test
    public void testGetBookListCheckedOut() throws Exception{
        String expectedString = "Harry Potter and the Philosopher's Stone by J.K. Rowling (1997) : available\n" +
                "The Catcher in the Rye by J.D. Salinger (1951) : available\n";
        assertEquals("Incorrect list",expectedString,testLibrary.getlistOfBooks(true));
    }

    @Test
    public void testGetBookListAvailable() throws Exception{
        String expectedString = "The Lord of the Rings by J.R.R. Tolkien (1954) : checked out\n" +
                "The Little Prince by Antoine de Saint-Exupéry (1943) : checked out\n" +
                "The Hunger Games by Suzanne Collins (2008) : checked out\n";
        assertEquals("Incorrect list",expectedString,testLibrary.getlistOfBooks(false));
    }

}
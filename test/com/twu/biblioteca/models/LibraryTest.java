package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library testLibrary = new Library();
    private Book availableBook = new Book("The Hunger Games","Suzanne Collins",2008);
    private Book checkedOutBook = new Book("The Catcher in the Rye","J.D. Salinger",1951,"John Doe");
    private Book notFoundBook = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "John Doe");


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

    }

    @Test
    public void testReturnBook() throws Exception {

    }

    @Test
    public void testCreateBook() throws Exception {

    }
}
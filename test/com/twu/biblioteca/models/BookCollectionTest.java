package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookCollectionTest {

    private BookCollection bookCollection = new BookCollection();
    private Book availableBook = new Book("The Hunger Games","Suzanne Collins",2008);
    private Book availableBook2 = new Book("The Little Prince","Antoine de Saint-Exupéry",1943);
    private Book checkedOutBook = new Book("The Catcher in the Rye","J.D. Salinger",1951,"123-1234");
    private Book notFoundBook = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "123-1234");
    private String customer = "123-1234";

    @Test
    public void testContainsBook() throws Exception {
        assertTrue("ContainsBook should be true", bookCollection.containsItem(availableBook.name()));
        assertFalse("ContainsBook should be false", bookCollection.containsItem(notFoundBook.name()));
    }

    @Test
    public void testIsBookAvailable(){
        assertTrue("IsBookAvailable should be true", bookCollection.isItemAvailable(availableBook.name()));
        assertFalse("IsBookAvailable should be false", bookCollection.isItemAvailable(checkedOutBook.name()));
    }

    @Test
    public void testGetBook() throws Exception {
        Book retrievedBook = bookCollection.getItem(availableBook.name());
        assertEquals("Incorrect book", availableBook, retrievedBook);
    }


    @Test
    public void testCheckOutBook() throws Exception {
        assertEquals("Book does not exist in library", bookCollection.checkOutItem(notFoundBook.name(), customer));
        assertEquals("Book is currently unavailable for checkout", bookCollection.checkOutItem(checkedOutBook.name(), customer));
        assertEquals("Thank you! Enjoy the book", bookCollection.checkOutItem(availableBook.name(), customer));

        Book checkedOutbook = bookCollection.getItem(availableBook.name());
        assertEquals("Incorrect checkout",customer, checkedOutbook.userID());
    }

    @Test
    public void testReturnBook() throws Exception {
        assertEquals("Book does not exist in library", bookCollection.returnItem(notFoundBook.name()));
        assertEquals("Book has already been returned", bookCollection.returnItem(availableBook2.name()));
        assertEquals("Thank you for returning the book", bookCollection.returnItem(checkedOutBook.name()));

        Book returnedBook = bookCollection.getItem(checkedOutBook.name());
        assertEquals("Incorrect return", null, returnedBook.userID());
    }

    @Test
    public void testGetBookListCheckedOut() throws Exception{
        String expectedString =
                        "============================================================================================================\n" +
                        "LIST OF BOOKS\n" +
                        "NAME                                                         AUTHOR                                     YEAR\n" +
                        "Harry Potter and the Philosopher's Stone                     J.K. Rowling                               1997\n" +
                        "The Catcher in the Rye                                       J.D. Salinger                              1951\n" +
                        "============================================================================================================";
        assertEquals("Incorrect list", expectedString, bookCollection.getLibraryCollection(false));
    }

    @Test
    public void testGetBookListAvailable() throws Exception{
        String expectedString =
                        "============================================================================================================\n" +
                        "LIST OF BOOKS\n" +
                        "NAME                                                         AUTHOR                                     YEAR\n" +
                        "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                        "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                        "The Hunger Games                                             Suzanne Collins                            2008\n" +
                        "============================================================================================================";
        assertEquals("Incorrect list", expectedString, bookCollection.getLibraryCollection(true));
    }

}
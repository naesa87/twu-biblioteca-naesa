package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;
import com.twu.biblioteca.models.exceptions.InvalidUserException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private String expectedName = "Hitchhiker's Guide to the Galaxy";
    private String expectedAuthor = "Douglas Adams";
    private String expectedCustomer = "123-1234";
    private int expectedYear = 1979;
    private Book typicalBook = new Book(expectedName,expectedAuthor,expectedYear);

    @Test
    public void testTypicalBookConstructorAndBasicGetters(){
        Book book = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);
        assertEquals("Incorrect name", expectedName, book.getName());
        assertEquals("Incorrect author", expectedAuthor, book.getAuthor());
        assertEquals("Incorrect year", expectedYear, book.getYear());
    }

    @Test
    public void testBookConstructorWithCustomerAndBasicGetters(){
        Book book = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "123-1234");
        assertEquals("Incorrect name", expectedName, book.getName());
        assertEquals("Incorrect author", expectedAuthor, book.getAuthor());
        assertEquals("Incorrect year", expectedYear, book.getYear());
        assertEquals("Incorrect customer", expectedCustomer, book.getUserID());
    }

    @Test(timeout=5000)
    public void testNullInBookConstructor() throws Exception {
        try {
            new Book(expectedName,null,expectedYear);
            fail("NullPointerException expected");
        } catch (Exception e) {
            assertTrue("NullPointerException expected",
                    e instanceof NullPointerException);
        }
        try {
            new Book(null,expectedAuthor,expectedYear);
            fail("NullPointerException expected");
        } catch (Exception e) {
            assertTrue("NullPointerException expected",
                    e instanceof NullPointerException);
        }
    }

    @Test(timeout=5000)
    public void testBadDateInBookConstructor() throws Exception {
        try {
            new Book(expectedName,expectedAuthor,20161);
            fail("InvalidBookException expected");
        } catch (Exception e) {
            assertTrue("InvalidBookException expected",
                    e instanceof InvalidBookException);
        }
    }

    @Test
    public void testSetCustomerGetCustomer() throws Exception {
        typicalBook.setUser(expectedCustomer);
        assertEquals("Incorrect Customer", expectedCustomer, typicalBook.getUserID());
        typicalBook.setUser(null);
        assertEquals("Incorrect Customer", null, typicalBook.getUserID());
    }


    @Test(expected = InvalidUserException.class, timeout=5000)
    public void testSetUserWithWrongFormat() throws Exception {
        typicalBook.setUser("A23-1234");
        typicalBook.setUser("");
    }

    @Test
    public void testBookIsCheckedOut(){
        typicalBook.setUser(expectedCustomer);
        typicalBook.isCheckedOut();
        assertEquals("IsCheckedOut should return true", true, typicalBook.isCheckedOut());
    }

    @Test
    public void basicEqualsTest() {
        Book sameBook1 = new Book(expectedName,expectedAuthor,expectedYear);
        Book sameBook2 = new Book(expectedName,expectedAuthor,expectedYear);
        Book difBook = new Book(expectedName,expectedAuthor,2015);

        assertTrue("Equals should return true", sameBook1.equals(sameBook2));
        assertFalse("Equals should return false", sameBook1.equals(difBook));
    }

    @Test
    public void basicEqualsTestWithCustomer() {
        Book sameBook1 = new Book(expectedName,expectedAuthor,expectedYear,expectedCustomer);
        Book sameBook2 = new Book(expectedName,expectedAuthor,expectedYear);
        sameBook2.setUser(expectedCustomer);
        Book difBook = new Book(expectedName,expectedAuthor,2015, "234-2345");

        assertTrue("Equals should return true", sameBook1.equals(sameBook2));
        assertFalse("Equals should return false", sameBook1.equals(difBook));
    }
}
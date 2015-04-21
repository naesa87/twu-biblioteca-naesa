package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private String expectedName = "Hitchhiker's Guide to the Galaxy";
    private String expectedAuthor = "Douglas Adams";
    private String expectedCustomer = "John Doe";
    private int expectedYear = 1979;
    private Book typicalBook = new Book(expectedName,expectedAuthor,expectedYear);

    @Test
    public void testTypicalBookConstructorAndBasicGetters(){
        Book book = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);
        assertEquals("Incorrect name", expectedName, book.name());
        assertEquals("Incorrect author", expectedAuthor, book.author());
        assertEquals("Incorrect year", expectedYear, book.year());
    }

    @Test
    public void testBookConstructorWithCustomerAndBasicGetters(){
        Book book = new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, "John Doe");
        assertEquals("Incorrect name", expectedName, book.name());
        assertEquals("Incorrect author", expectedAuthor, book.author());
        assertEquals("Incorrect year", expectedYear, book.year());
        assertEquals("Incorrect customer", expectedCustomer, book.customer());
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
        typicalBook.setCustomer("John Doe");
        assertEquals("Incorrect Customer", expectedCustomer, typicalBook.customer());
        typicalBook.setCustomer(null);
        assertEquals("Incorrect Customer", null, typicalBook.customer());
    }

    @Test(expected = InvalidBookException.class, timeout=5000)
    public void testWhiteSpaceCustomerName() {
        typicalBook.setCustomer("");
        typicalBook.setCustomer("   ");
    }

    @Test
    public void testBookIsCheckedOut(){
        typicalBook.setCustomer(expectedCustomer);
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
        sameBook2.setCustomer(expectedCustomer);
        Book difBook = new Book(expectedName,expectedAuthor,2015, "Stranger");

        assertTrue("Equals should return true", sameBook1.equals(sameBook2));
        assertFalse("Equals should return false", sameBook1.equals(difBook));
    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.models.exceptions.InvalidBookException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private String expectedName = "Hitchhiker's Guide";
    private String expectedAuthor = "Douglas Adams";
    private String expectedCustomer = "John Doe";
    private int expectedYear = 2012;
    private Book typicalBook = new Book(expectedName,expectedAuthor,expectedYear);

    @Test
    public void testTypicalBookConstructorAndBasicGetters(){
        Book book = new Book("Hitchhiker's Guide", "Douglas Adams", 2012);
        assertEquals("Incorrect name", expectedName, book.name());
        assertEquals("Incorrect author", expectedAuthor, book.author());
        assertEquals("Incorrect year", expectedYear, book.year());
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
            new Book(expectedName,expectedAuthor,500000);
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
        assertEquals("Book is not checkedout", true, typicalBook.isCheckedOut());
    }

}
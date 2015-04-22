package com.twu.biblioteca.helpers;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidationHelperTest {

    @Test
    public void testIsValidYear() throws Exception {
        assertTrue("Valid year should be true",ValidationHelper.isValidYear(0));
        assertTrue("Valid year should be true",ValidationHelper.isValidYear(1900));
        assertTrue("Valid year should be true",ValidationHelper.isValidYear(2015));
        assertFalse("Valid year should be false", ValidationHelper.isValidYear(-5));
        assertFalse("Valid year should be false", ValidationHelper.isValidYear(-2016));
    }

    @Test
    public void testIsValidRating() throws Exception {
        assertTrue("Valid Rating should be true",ValidationHelper.isValidRating(null));
        assertTrue("Valid Rating should be true",ValidationHelper.isValidRating(1));
        assertTrue("Valid Rating should be true",ValidationHelper.isValidRating(10));
        assertFalse("Valid Rating should be false", ValidationHelper.isValidRating(0));
        assertFalse("Valid Rating should be false", ValidationHelper.isValidRating(-5));
        assertFalse("Valid Rating should be false", ValidationHelper.isValidRating(11));

    }

    @Test
    public void testIsValidUserID() throws Exception {
        assertTrue("Valid LibraryID should be true", ValidationHelper.isValidUserID("123-1234"));
        assertTrue("Valid LibraryID should be true", ValidationHelper.isValidUserID("000-0000"));
        assertFalse("Valid LibraryID should be false", ValidationHelper.isValidUserID("A23-1234"));
        assertFalse("Valid LibraryID should be false", ValidationHelper.isValidUserID("1231234"));
        assertFalse("Valid LibraryID should be false", ValidationHelper.isValidUserID(""));
        assertFalse("Valid LibraryID should be false", ValidationHelper.isValidUserID("0"));
    }
}
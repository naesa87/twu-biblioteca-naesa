package com.twu.biblioteca.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    @Test
    public void testIsNotWhitespace() throws Exception {
        String noSpace ="";
        String oneWhiteSpace = " ";
        String twoWhiteSpace = "   ";
        String lotsOfWhiteSpace = "               ";
        String whiteSpaceBetweenChars = "asdf asdf";
        String whiteSpaceBeforeAfterChars = " asdf  ";
        assertFalse(StringHelper.isNotWhitespace(noSpace));
        assertFalse(StringHelper.isNotWhitespace(oneWhiteSpace));
        assertFalse(StringHelper.isNotWhitespace(twoWhiteSpace));
        assertFalse(StringHelper.isNotWhitespace(lotsOfWhiteSpace));
        assertTrue(StringHelper.isNotWhitespace(whiteSpaceBetweenChars));
        assertTrue(StringHelper.isNotWhitespace(whiteSpaceBeforeAfterChars));
    }

}
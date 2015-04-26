package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountsTest {

    private UserAccounts userAccounts = new UserAccounts();
    private String presentUserID = "123-1234";
    private String notPresentUserID = "222-2222";


    @Test
    public void testContainsUserID() throws Exception {
        assertTrue(userAccounts.containsUserID(presentUserID));
        assertFalse(userAccounts.containsUserID(notPresentUserID));
    }

    @Test
    public void testGetUserIfValidPassword() throws Exception {
        String correctPassword = "password";
        String incorrectPassword = "password123";
        User user = new User("123-1234","password","John Dorian","jd@gmail.com","0420-123-1234");

        assertEquals(user, userAccounts.getUserIfValidPassword(presentUserID,correctPassword));
        assertEquals(null, userAccounts.getUserIfValidPassword(presentUserID,incorrectPassword));
        assertEquals(null, userAccounts.getUserIfValidPassword(notPresentUserID,correctPassword));

    }
}
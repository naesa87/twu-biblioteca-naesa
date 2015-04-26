package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by naesa on 26/04/15.
 */
public class UserTest {

    private String expectedUserID = "123-1234";
    private String expectedPassword = "password";
    private String expectedFullName= "John Dorian";
    private String expectedEmail = "jd@gmail.com";
    private String expectedPhone = "0420-123-1234";

    @Test
    public void testTypicalBookConstructorAndBasicGetters(){
        User user  = new User("123-1234","password","John Dorian","jd@gmail.com","0420-123-1234");
        assertEquals("Incorrect user id", expectedUserID, user.getUserID());
        assertEquals("Incorrect password", expectedPassword, user.getPassword());
        assertEquals("Incorrect full name", expectedFullName, user.getFullName());
        assertEquals("Incorrect email", expectedEmail, user.getEmail());
        assertEquals("Incorrect phone", expectedPhone, user.getPhone());
    }


    @Test
    public void basicEqualsTest() {
        User sameUser1 = new User(expectedUserID,expectedPassword,expectedFullName,expectedEmail,expectedPhone);
        User sameUser2 = new User(expectedUserID,expectedPassword,expectedFullName,expectedEmail,expectedPhone);
        User difUser = new User(expectedUserID,"password123",expectedFullName,expectedEmail,expectedPhone);

        assertTrue("Equals should return true", sameUser1.equals(sameUser2));
        assertFalse("Equals should return false", sameUser1.equals(difUser));
    }

    @Test
    public void testToString() throws Exception {
        User user  = new User("123-1234","password","John Dorian","jd@gmail.com","0420-123-1234");
        String expectedAccountInformation=
                "name: John Dorian\n" +
                "email: jd@gmail.com\n" +
                "phone: 0420-123-1234";
        assertEquals(expectedAccountInformation,user.toString());
    }
}
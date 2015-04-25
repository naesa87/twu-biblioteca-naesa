package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainMenuTest {

    private List<String> expectedOptions = new ArrayList<String>();
    private MainMenu mainMenu = new MainMenu();

    @Before
    public void setUp() throws Exception {
        expectedOptions.add("List Books");
        expectedOptions.add("List Movies");
        expectedOptions.add("Account Information");
    }

    @Test
    public void testGetOptions(){
        assertEquals("Incorrect options", expectedOptions, mainMenu.getOptions());
    }

    @Test
    public void testToString(){
        String expectedString =
                "============================================================================================================\n" +
                "MAIN MENU OPTIONS\n" +
                "List Books\n" +
                "List Movies\n" +
                "Account Information\n" +
                "============================================================================================================";
        assertEquals("Incorrect String printout",expectedString, mainMenu.toString());
    }
}
package com.twu.biblioteca;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class BibliotecaAppTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();




    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams(){
        System.setOut(null);
    }

    @Test
    public void testRun() throws Exception {
        systemInMock.provideText("123-1234\npassword\nlist books\nquit");
        assertEqualsWithExit(expectedRunOutput);
        new BibliotecaApp().run();
    }

    private void assertEqualsWithExit(final String expectedOutput) {
        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                assertEquals(expectedOutput, outContent.toString());
            }
        });
    }

    private String expectedRunOutput="WELCOME TO BIBLIOTECA!\n" +
            "(to exit application at any time enter: quit)\n" +
            "What's your library user id?:\n" +
            "What's your password?:\n" +
            "Hi 123-1234\n" +
            "============================================================================================================\n" +
            "MAIN MENU OPTIONS\n" +
            "List Books\n" +
            "List Movies\n" +
            "Account Information\n" +
            "============================================================================================================\n" +
            "Please choose a menu option\n" +
            "============================================================================================================\n" +
            "LIST OF BOOKS\n" +
            "NAME                                                         AUTHOR                                     YEAR\n" +
            "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
            "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
            "The Hunger Games                                             Suzanne Collins                            2008\n" +
            "============================================================================================================\n" +
            "to borrow a book enter: Checkout \"Book Name\" (no quotes)\n" +
            "to return a book enter: Return \"Book Name\" (no quotes)\n" +
            "to go back to main menu enter: back\n" +
            "Please enter a command\n" +
            "Thank you. Goodbye!\n";
}
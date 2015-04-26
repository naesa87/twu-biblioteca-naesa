package com.twu.biblioteca;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import static com.twu.biblioteca.TestStringConstants.*;
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

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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


}
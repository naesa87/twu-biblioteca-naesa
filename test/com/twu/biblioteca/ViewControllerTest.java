package com.twu.biblioteca;

import com.twu.biblioteca.models.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.*;

import static org.junit.Assert.*;

/*  NOTE: ViewController methods always loop back to a System input request, so it is necessary to provide all
*   inputs up to one that can exit the loop (usually the correct input request), otherwise
*   the console will keep looking for an input and when there is none, it will create a NPE.
*
*   Expected outputs from console only show what System prints out, it will not include the given inputs
*   */
public class ViewControllerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;
    
    private Library library = new Library();
    private String nextInput = System.getProperty("line.separator");
    BufferedReader reader;

    private String nothing = "";
    private String oneSpace = " ";
    private String randomLetters = "asdf";
    private String numbersWrongFormatUserId = "1231234";
    private String correctFormatUserId = "123-1234";
    private String quit = "quit";

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams(){
        System.setOut(null);
        System.setIn(null);
    }

    @Test
    public void testWelcomeView(){

        String mockInput= nothing+nextInput
                        +oneSpace+nextInput
                        +randomLetters+nextInput
                        +nothing+nextInput
                        +numbersWrongFormatUserId+nextInput
                        +correctFormatUserId;
        setupInputStream(mockInput);

        ViewController vc = new ViewController(library, reader);
        vc.welcomeView();
        assertEquals(expectedWelcomeViewOutput, outContent.toString());
    }

    @Test
    public void testWelcomeViewQuit(){
        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                assertEquals("WELCOME TO BIBLIOTECA!\n" +
                        "(to exit application enter quit at any time)\n" +
                        "What's your library user id?:\n" +
                        "Thank you. Goodbye!\n", outContent.toString());
            }
        });
        setupInputStream(quit);

        ViewController vc = new ViewController(library, reader);
        vc.welcomeView();

    }

    private void setupInputStream(String mockInput) {
        inContent = new ByteArrayInputStream(mockInput.getBytes());
        reader = new BufferedReader(new InputStreamReader(inContent));
    }


    private String expectedWelcomeViewOutput="WELCOME TO BIBLIOTECA!\n" +
            "(to exit application enter quit at any time)\n" +
            "What's your library user id?:\n" +
            "(Please type a valid name)\n" +

            "What's your library user id?:\n" +
            "(Please type a valid name)\n" +

            "What's your library user id?:\n" +
            "(Please type a valid name)\n" +

            "What's your library user id?:\n" +
            "(Please type a valid name)\n" +

            "What's your library user id?:\n" +
            "(Please type a valid name)\n" +

            "What's your library user id?:\n" +
            "Hi 123-1234\n";
}
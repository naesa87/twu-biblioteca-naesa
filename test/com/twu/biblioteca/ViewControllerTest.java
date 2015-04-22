package com.twu.biblioteca;

import com.twu.biblioteca.models.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/*  NOTE: ViewController methods always loop back to an input request, so it is necessary to provide all
*   inputs up to one that can exit the loop (usually the correct input request), otherwise
*   the console will keep looking for an input and when there is none, it will create a NPE.
*
*   Expected outputs from console only show what System prints out, it will not include the given inputs
*   */
public class ViewControllerTest {

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

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
//        System.setIn(new PrintStream(inContent));
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
        inContent = new ByteArrayInputStream(mockInput.getBytes());
        reader = new BufferedReader(new InputStreamReader(inContent));
        ViewController vc = new ViewController(library, reader);
        vc.welcomeView();
        assertEquals("WELCOME TO BIBLIOTECA!\n" +
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
                "Hi 123-1234\n", outContent.toString());
    }

//    @Test
//    public void testMainMenuView(){
//        inContent = new ByteArrayInputStream("books".getBytes());
//        reader = new BufferedReader(new InputStreamReader(inContent));
//        ViewController vc = new ViewController(library, reader);
//        vc.libraryView();
//
//    }
}
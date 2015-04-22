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
*   inputs up to one that can exit the loop (usually the correct input request or "quit"), otherwise
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

    //inputs
    private String nothing = "";
    private String oneSpace = " ";
    private String randomLetters = "asdf";
    private String lettersWithSpacesBetween = "as df";
    private String lettersWithSpacesBeforeAfter= "  asdf  ";
    private String numbersWrongFormatUserId = "1231234";
    private String correctFormatUserId = "123-1234";
    private String listBooksTypical = "List Books";
    private String listBooksLowercase = "list books";
    private String listBooksUppercase = "LIST BOOKS";
    private String listbooksSpaceBeforeAfter = "   List Books    ";
    private String CheckoutNothing = "Checkout";
    private String CheckoutBookNotExist = "Checkout The Giver";
    private String CheckoutBookNotAvailable = "Checkout The Catcher in the Rye";
    private String CheckoutCorrect = "Checkout The Little Prince";
    private String CheckoutBookLowercase = "checkout the little prince";
    private String CheckoutBookSpaceBeforeAfter = "   Checkout The Little Prince    ";

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
    public void testWelcomeViewQuit(){
        assertEqualsWithExit(
                "WELCOME TO BIBLIOTECA!\n" +
                "(to exit application enter quit at any time)\n" +
                "What's your library user id?:\n" +
                "Thank you. Goodbye!\n");

        setupInputStream(quit);
        ViewController vc = new ViewController(library, reader);
        vc.welcomeView();
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
    public void testMainMenuViewQuit(){
        assertEqualsWithExit(expectedMainMenuViewQuitOutput);
        setupInputStream(quit);

        executeMainMenuView();
    }

    private void executeMainMenuView() {
        ViewController vc = new ViewController(library, reader);
        vc.mainMenuView();
    }



    // need exit protocol as quiting is the only way to leave MainMenuView
    // without entering another view
    @Test
    public void testMainMenuViewErrors(){
        assertEqualsWithExit(expectedMainMenuViewErrorsOutput);

        String mockInput= nothing+nextInput
                +oneSpace+nextInput
                +randomLetters+nextInput
                +nothing+nextInput
                +lettersWithSpacesBetween+nextInput
                +lettersWithSpacesBeforeAfter+nextInput
                +quit;
        setupInputStream(mockInput);

        executeMainMenuView();
    }

    @Test
    public void testMainMenuViewListBooksOption(){
        assertEqualsWithExit(expectedMainMenuViewCorrectOptionOutput);

        String mockInput= listBooksTypical+nextInput +quit;
        setupInputStream(mockInput);

        executeMainMenuView();
    }

    @Test
    public void testMainMenuViewListBooksOptionLowercase(){
        assertEqualsWithExit(expectedMainMenuViewCorrectOptionOutput);

        String mockInput= listBooksLowercase+nextInput +quit;
        setupInputStream(mockInput);

        executeMainMenuView();
    }

    @Test
    public void testMainMenuViewListBooksOptionUppercase(){
        assertEqualsWithExit(expectedMainMenuViewCorrectOptionOutput);

        String mockInput= listBooksUppercase+nextInput +quit;
        setupInputStream(mockInput);

        executeMainMenuView();
    }

    @Test
    public void testMainMenuViewListBooksOptionWithSpaces(){
        assertEqualsWithExit(expectedMainMenuViewCorrectOptionOutput);

        String mockInput= listbooksSpaceBeforeAfter+nextInput +quit;
        setupInputStream(mockInput);

        executeMainMenuView();
    }

    @Test
    public void testLibraryViewQuit(){
        assertEqualsWithExit(expectedLibraryViewQuitOutput);
        setupInputStream(quit);

        executeLibraryView();
    }

    private void executeLibraryView() {
        ViewController vc = new ViewController(library, reader);
        vc.libraryView();
    }

    private void setupInputStream(String mockInput) {
        inContent = new ByteArrayInputStream(mockInput.getBytes());
        reader = new BufferedReader(new InputStreamReader(inContent));
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

    private String expectedMainMenuViewQuitOutput=
            "============================================================================================================\n" +
            "MAIN MENU OPTIONS\n" +
            "List Books\n" +
            "List Movies\n" +
            "============================================================================================================\n" +
            "Please choose a menu option\n" +
            "Thank you. Goodbye!\n";

    private String expectedMainMenuViewErrorsOutput="============================================================================================================\n" +
            "MAIN MENU OPTIONS\n" +
            "List Books\n" +
            "List Movies\n" +
            "============================================================================================================\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Invalid option\n" +
            "Please choose a menu option\n" +
            "Thank you. Goodbye!\n";

    private String expectedMainMenuViewCorrectOptionOutput=
            "============================================================================================================\n" +
                    "MAIN MENU OPTIONS\n" +
                    "List Books\n" +
                    "List Movies\n" +
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

    private String expectedLibraryViewQuitOutput="============================================================================================================\n" +
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
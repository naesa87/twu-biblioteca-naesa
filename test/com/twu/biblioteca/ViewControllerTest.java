package com.twu.biblioteca;

import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.MovieCollection;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.models.UserAccounts;
import static com.twu.biblioteca.TestStringConstants.*;
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
    private final String WELCOME_VIEW = "WelcomeView";
    private final String MAIN_MENU_VIEW = "MainMenuView";
    private final String LIBRARY_VIEW = "LibraryView";


    private BookCollection bookCollection = new BookCollection();
    private MovieCollection movieCollection = new MovieCollection();
    private UserAccounts userAccounts = new UserAccounts();
    private User user = userAccounts.getUserIfValidPassword("123-1234","password");
    private String nextInput = System.getProperty("line.separator");
    private ByteArrayInputStream inContent;
    BufferedReader reader;

    //inputs
    private String nothing = "";
    private String oneSpace = " ";
    private String randomLetters = "asdf";
    private String lettersWithSpacesBetween = "as df";
    private String lettersWithSpacesBeforeAfter= "  asdf  ";

    private String numbersWrongFormatUserId = "1231234";
    private String correctFormatUserId = "123-1234";
    private String doesNotExistUserId = "222-2222";
    private String password = "password";
    private String wrongPassword = "password123";

    private String listBooksTypical = "List Books";
    private String listBooksLowercase = "list books";
    private String listBooksUppercase = "LIST BOOKS";
    private String listbooksSpaceBeforeAfter = "   List Books    ";
    private String checkoutNothing = "Checkout";
    private String checkoutBookNotExist = "Checkout The Giver";
    private String checkoutBookNotAvailable = "Checkout The Catcher in the Rye";
    private String checkoutBookCorrect = "Checkout The Little Prince";
    private String checkoutBookLowercase = "checkout the little prince";
    private String checkoutBookSpaceBeforeAfter = "   Checkout The Little Prince    ";
    private String returnNothing = "Return";
    private String returnBookNotExist = "Return The Giver";
    private String returnBookNotAvailable = "Return The Little Prince";
    private String returnBookCorrect = "Return The Catcher in the Rye";
    private String returnBookLowercase = "return the catcher in the rye";
    private String returnBookSpaceBeforeAfter = "   Return The Catcher in the Rye    ";

    private String listMovies = "List Movies";
    private String checkoutMovieNotExist = "Checkout Avengers";
    private String checkoutMovieNotAvailable = "Checkout The Godfather";
    private String checkoutMovieCorrect = "Checkout Fight Club";
    private String returnMovieNotExist = "Return Avengers";
    private String returnMovieAlreadyReturned = "Return Mean Girls";
    private String returnMovieCorrect = "Return Fight Club";
    private String accountInformationCommand = "Account Information";

    private String back = "back";
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
        assertEqualsWithExit("WELCOME TO BIBLIOTECA!\n" +
                "(to exit application at any time enter: quit)\n" +
                "What's your library user id?:\n" +
                "Thank you. Goodbye!\n");
        executeViewWithInput(WELCOME_VIEW, quit);
    }

    @Test
    public void testWelcomeView(){
        String mockInput= nothing+nextInput
                        +oneSpace+nextInput
                        +randomLetters+nextInput
                        +nothing+nextInput
                        +numbersWrongFormatUserId+nextInput
                        +correctFormatUserId+nextInput
                        +password;
        executeViewWithInput(WELCOME_VIEW, mockInput);
        assertEquals(expectedWelcomeViewOutput, outContent.toString());
    }

    @Test
    public void testUserIdPasswordAuthentication(){
        String mockInput = doesNotExistUserId+nextInput
                    +password+nextInput
                    +correctFormatUserId+nextInput
                    +wrongPassword+nextInput
                    +correctFormatUserId+nextInput
                    +password;
        executeViewWithInput(WELCOME_VIEW, mockInput);
        assertEquals(expectedUserAuthenticationOutput, outContent.toString());
    }

    @Test
    public void testMainMenuViewQuit(){
        assertEqualsWithExit(expectedMainMenuViewQuitOutput);
        executeViewWithInput(MAIN_MENU_VIEW, quit);
    }


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
        executeViewWithInput(MAIN_MENU_VIEW, mockInput);
    }

    @Test
    public void testMainMenuViewAccountInformationOption(){
        String requiredEnding = nextInput+quit;
        assertEqualsWithExit(expectedAccountInformationOutput);
        executeViewWithInput(MAIN_MENU_VIEW, accountInformationCommand + requiredEnding);
    }

    @Test
    public void testMainMenuViewListBooksOption(){
        assertCorrectListBooksOption(listBooksTypical);
    }

    @Test
    public void testMainMenuViewListBooksOptionLowercase(){
        assertCorrectListBooksOption(listBooksLowercase);
    }

    @Test
    public void testMainMenuViewListBooksOptionUppercase(){
        assertCorrectListBooksOption(listBooksUppercase);
    }

    @Test
    public void testMainMenuViewListBooksOptionWithSpaces(){
        assertCorrectListBooksOption(listbooksSpaceBeforeAfter);
    }

    @Test
    public void testMainMenuViewListMoviesOption(){
        assertCorrectListMoviesOption(listMovies);
    }


    @Test
    public void tesLibrarytViewQuit(){
        assertEqualsWithExit(expectedLibraryViewQuitOutput);
        executeViewWithInput(LIBRARY_VIEW, quit);
    }

    @Test
    public void testLibraryViewCommandErrors(){
        assertEqualsWithExit(expectedLibraryViewCommandErrorsOutput);
        String mockInput= nothing+nextInput
                +oneSpace+nextInput
                +randomLetters+nextInput
                +nothing+nextInput
                +quit;
        executeViewWithInput(LIBRARY_VIEW, mockInput);
    }

    @Test
    public void testLibraryViewReturnErrors(){
        assertEqualsWithExit(expectedLibraryViewReturnErrorsOutput);
        String mockInput=
                returnNothing+nextInput
                +returnBookNotExist+nextInput
                +returnBookNotAvailable+nextInput
                +quit;
        executeViewWithInput(LIBRARY_VIEW, mockInput);
    }

    @Test
    public void testLibraryViewCorrectReturnCommand(){
        assertCorrectLibraryOption(returnBookCorrect, expectedLibraryViewCorrectReturnOutput);
    }

    @Test
    public void testLibraryViewCorrectReturnCommandLowercase(){
        assertCorrectLibraryOption(returnBookLowercase, expectedLibraryViewCorrectReturnOutput);
    }

    @Test
    public void testLibraryViewCorrectReturnCommandWithSpaces(){
        assertCorrectLibraryOption(returnBookSpaceBeforeAfter, expectedLibraryViewCorrectReturnOutput);
    }

    @Test
    public void testLibraryViewCheckoutErrors(){
        assertEqualsWithExit(expectedLibraryViewCheckoutErrorsOutput);
        String mockInput=
                checkoutNothing+nextInput
                        +checkoutBookNotExist+nextInput
                        +checkoutBookNotAvailable+nextInput
                        +quit;
        executeViewWithInput(LIBRARY_VIEW, mockInput);
    }

    @Test
    public void testLibraryViewCorrectCheckoutCommand(){
        assertCorrectLibraryOption(checkoutBookCorrect, expectedLibraryViewCorrectCheckoutOutput);
    }

    @Test
    public void testLibraryViewCorrectCheckoutCommandLowercase(){
        assertCorrectLibraryOption(checkoutBookLowercase, expectedLibraryViewCorrectCheckoutOutput);
    }

    @Test
    public void testLibraryViewCorrectCheckoutCommandWithSpaces(){
        assertCorrectLibraryOption(checkoutBookSpaceBeforeAfter, expectedLibraryViewCorrectCheckoutOutput);
    }


    @Test
    public void testLibraryViewMovieReturnErrors(){
        assertEqualsWithExit(expectedLibraryViewMovieReturnErrorsOutput);
        String mockInput=
                returnNothing+nextInput
                        +returnMovieNotExist+nextInput
                        +returnMovieAlreadyReturned+nextInput
                        +quit;
        executeViewWithInput(LIBRARY_VIEW, mockInput);
    }

    @Test
    public void testLibraryViewCorrectMovieReturnCommand(){
        assertCorrectLibraryOption(returnMovieCorrect, expectedLibraryViewMovieCorrectReturnOutput);
    }

    @Test
    public void testLibraryViewMovieCheckoutErrors(){
        assertEqualsWithExit(expectedLibraryViewMovieCheckoutErrorsOutput);
        String mockInput=
                checkoutNothing+nextInput
                        +checkoutMovieNotExist+nextInput
                        +checkoutMovieNotAvailable+nextInput
                        +quit;
        executeViewWithInput(LIBRARY_VIEW, mockInput);
    }

    @Test
    public void testLibraryViewMovieCorrectCheckoutCommand(){
        assertCorrectLibraryOption(checkoutMovieCorrect, expectedLibraryViewMovieCorrectCheckoutOutput);
    }


    @Test
    public void testLibraryViewBackCommand(){
        executeViewWithInput(LIBRARY_VIEW, back);
        assertEquals(expectedLibraryViewBackCommandOutput, outContent.toString());
    }

    @Test
    public void testLibraryViewBackCommandWithSpaces(){
        executeViewWithInput(LIBRARY_VIEW, back);
        assertEquals(expectedLibraryViewBackCommandOutput, outContent.toString());
    }
    

    private void executeViewWithInput(String view, String input) {
        setupInputStream(input);
        ViewController vc = new ViewController(bookCollection, movieCollection, userAccounts, reader);
        if (view.equalsIgnoreCase(WELCOME_VIEW)) { vc.welcomeView();}
        else if (view.equalsIgnoreCase(MAIN_MENU_VIEW)) { vc.setUser(user); vc.mainMenuView();}
        else if (view.equalsIgnoreCase(LIBRARY_VIEW))
        {
            vc.setUser(user);
            vc.collectionView("book");
        }
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

    private void assertCorrectListBooksOption(String mockInput) {
        String requiredEnding = nextInput+quit;
        assertEqualsWithExit(expectedMainMenuViewCorrectOptionOutput);
        executeViewWithInput(MAIN_MENU_VIEW, mockInput + requiredEnding);
    }

    private void assertCorrectListMoviesOption(String mockInput) {
        String requiredEnding = nextInput+quit;
        assertEqualsWithExit(expectedMainMenuViewCorrectMoviesOption);
        executeViewWithInput(MAIN_MENU_VIEW, mockInput + requiredEnding);
    }
    private void assertCorrectLibraryOption(String mockInput, String expectedOutput) {
        String requiredEnding = nextInput+quit;
        assertEqualsWithExit(expectedOutput);
        executeViewWithInput(LIBRARY_VIEW, mockInput + requiredEnding);
    }


}
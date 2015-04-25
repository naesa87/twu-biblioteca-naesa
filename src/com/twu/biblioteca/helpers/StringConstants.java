package com.twu.biblioteca.helpers;

public class StringConstants {

    public static final String QUIT = "quit";
    public static final String WELCOME_MSG= "Welcome to Biblioteca!";
    public static final String BYE_MSG = "Thank you. Goodbye!";
    public static final String NAME_PROMPT = "What's your library user id?:";
    public static final String NAME_ERROR = "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]";
    public static final String MENU_PROMPT = "Please choose a menu option";
    public static final String MENU_ERROR = "[ Invalid option ]";
    public static final String LIBRARY_PROMPT = "Please enter a command";
    public static final String LIBRARY_ERROR = "[ Invalid library command ]";
    public static final String QUIT_INSTRUCTION = "(to exit application at any time enter: quit)";
    public static final String BOOK_COLLECTION_INSTRUCTIONS = "to borrow a book enter: Checkout \"Book Name\" (no quotes)\n"
            +"to return a book enter: Return \"Book Name\" (no quotes)\n"+
            "to go back to main menu enter: back";
    public static final String MOVIE_COLLECTION_INSTRUCTIONS = "to borrow a movie enter: Checkout \"Movie Name\" (no quotes)\n"
            +"to return a book enter: Return \"Movie Name\" (no quotes)\n"+
            "to go back to main menu enter: back";
    public static final String LS = System.getProperty("line.separator");
}

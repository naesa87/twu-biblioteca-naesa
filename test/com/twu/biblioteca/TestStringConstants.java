package com.twu.biblioteca;

public class TestStringConstants {

    public static final String expectedRunOutput="WELCOME TO BIBLIOTECA!\n" +
            "(to exit application at any time enter: quit)\n" +
            "What's your library user id?:\n" +
            "What's your password?:\n" +
            "Hi John Dorian\n" +
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

        public static final String expectedWelcomeViewOutput=   "WELCOME TO BIBLIOTECA!\n" +
                "(to exit application at any time enter: quit)\n" +
                "What's your library user id?:\n" +
                "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]\n" +
                "What's your library user id?:\n" +
                "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]\n" +
                "What's your library user id?:\n" +
                "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]\n" +
                "What's your library user id?:\n" +
                "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]\n" +
                "What's your library user id?:\n" +
                "[ Please type a valid user id with format xxx-xxxx (eg. 123-1234) ]\n" +
                "What's your library user id?:\n" +
                "What's your password?:\n"+
                "Hi John Dorian\n";

        public static final String expectedUserAuthenticationOutput ="WELCOME TO BIBLIOTECA!\n" +
                "(to exit application at any time enter: quit)\n" +
                "What's your library user id?:\n" +
                "What's your password?:\n" +
                "[ The usedID or password you entered is incorrect. ]\n" +
                "What's your library user id?:\n" +
                "What's your password?:\n" +
                "[ The usedID or password you entered is incorrect. ]\n" +
                "What's your library user id?:\n" +
                "What's your password?:\n" +
                "Hi John Dorian\n";

        public static final String expectedMainMenuViewQuitOutput=
                "============================================================================================================\n" +
                        "MAIN MENU OPTIONS\n" +
                        "List Books\n" +
                        "List Movies\n" +
                        "Account Information\n" +
                        "============================================================================================================\n" +
                        "Please choose a menu option\n" +
                        "Thank you. Goodbye!\n";

        public static final String expectedMainMenuViewErrorsOutput="============================================================================================================\n" +
                "MAIN MENU OPTIONS\n" +
                "List Books\n" +
                "List Movies\n" +
                "Account Information\n" +
                "============================================================================================================\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "[ Invalid option ]\n" +
                "Please choose a menu option\n" +
                "Thank you. Goodbye!\n";


        public static final String expectedMainMenuViewCorrectMoviesOption="============================================================================================================\n" +
                "MAIN MENU OPTIONS\n" +
                "List Books\n" +
                "List Movies\n" +
                "Account Information\n" +
                "============================================================================================================\n" +
                "Please choose a menu option\n" +
                "============================================================================================================\n" +
                "LIST OF MOVIES\n" +
                "NAME                                     AUTHOR                         RATING                YEAR\n" +
                "Eternal Sunshine of the Spotless Mind    Michel Gondry                  9                     2004\n" +
                "Fight Club                               David Fincher                  8                     1999\n" +
                "Mean Girls                               Mark Waters                    9                     2004\n" +
                "============================================================================================================\n" +
                "to borrow a movie enter: Checkout \"Movie Name\" (no quotes)\n" +
                "to return a book enter: Return \"Movie Name\" (no quotes)\n" +
                "to go back to main menu enter: back\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedMainMenuViewCorrectOptionOutput=
                "============================================================================================================\n" +
                        "MAIN MENU OPTIONS\n" +
                        "List Books\n" +
                        "List Movies\n" +
                        "Account Information\n" +                    "============================================================================================================\n" +
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

        public static final String expectedLibraryViewQuitOutput="============================================================================================================\n" +
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

        public static final String expectedLibraryViewCommandErrorsOutput="============================================================================================================\n" +
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
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewCheckoutErrorsOutput="============================================================================================================\n" +
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
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "[ Book is currently unavailable for checkout ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewCorrectCheckoutOutput = "============================================================================================================\n" +
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
                "Thank you! Enjoy the book\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewReturnErrorsOutput="============================================================================================================\n" +
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
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "[ Book has already been returned ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewCorrectReturnOutput ="============================================================================================================\n" +
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
                "Thank you for returning the book\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Catcher in the Rye                                       J.D. Salinger                              1951\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewBackCommandOutput = "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "to borrow a book enter: Checkout \"Book Name\" (no quotes)\n" +
                "to return a book enter: Return \"Book Name\" (no quotes)\n" +
                "to go back to main menu enter: back\n" +
                "Please enter a command\n";

        public static final String expectedAccountInformationOutput ="============================================================================================================\n" +
                "MAIN MENU OPTIONS\n" +
                "List Books\n" +
                "List Movies\n" +
                "Account Information\n" +
                "============================================================================================================\n" +
                "Please choose a menu option\n" +
                "name: John Dorian\n" +
                "email: jd@gmail.com\n" +
                "phone: 0420-123-1234\n" +
                "============================================================================================================\n" +
                "MAIN MENU OPTIONS\n" +
                "List Books\n" +
                "List Movies\n" +
                "Account Information\n" +
                "============================================================================================================\n" +
                "Please choose a menu option\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewMovieReturnErrorsOutput ="============================================================================================================\n" +
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
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewMovieCorrectReturnOutput="============================================================================================================\n" +
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
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

        public static final String expectedLibraryViewMovieCheckoutErrorsOutput="============================================================================================================\n" +
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
                "[ Invalid library command ]\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";
        public static final String expectedLibraryViewMovieCorrectCheckoutOutput="============================================================================================================\n" +
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
                "[ Book does not exist in library ]\n" +
                "============================================================================================================\n" +
                "LIST OF BOOKS\n" +
                "NAME                                                         AUTHOR                                     YEAR\n" +
                "The Lord of the Rings                                        J.R.R. Tolkien                             1954\n" +
                "The Little Prince                                            Antoine de Saint-Exupéry                   1943\n" +
                "The Hunger Games                                             Suzanne Collins                            2008\n" +
                "============================================================================================================\n" +
                "Please enter a command\n" +
                "Thank you. Goodbye!\n";

}

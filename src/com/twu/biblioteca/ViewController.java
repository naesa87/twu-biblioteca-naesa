package com.twu.biblioteca;

import static com.twu.biblioteca.helpers.StringConstants.*;
import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.*;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;

public class ViewController {


    private static final MainMenu mainMenu = new MainMenu();

    private BookCollection bookCollection;
    private MovieCollection movieCollection;
    private UserAccounts userAccounts;
    private String customer;
    private User user;
    private BufferedReader reader;

    public ViewController(BookCollection bookCollection, MovieCollection movieCollection, UserAccounts userAccounts, BufferedReader reader){
        this.bookCollection = bookCollection;
        this.movieCollection = movieCollection;
        this.userAccounts = userAccounts;
        this.reader = reader;
    }

    public void welcomeView(){
        display(WELCOME_MSG.toUpperCase());
        display(QUIT_INSTRUCTION);
        display(NAME_PROMPT);
        try {
            while (true){
                customer = reader.readLine().trim();
                checkForQuitRequest(customer);
                if (isValidCustomerName()){
                    display("Hi " + customer);
                    return;
                }
                display(NAME_ERROR);
                display(NAME_PROMPT);
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

    public void mainMenuView(){
        display(mainMenu);
        String command;
        try{
            while(true){
                display(MENU_PROMPT);
                command = reader.readLine();

                checkForQuitRequest(command);
                boolean validOption = isValidMainMenuOption(command);
                if(!validOption) { display(MENU_ERROR); }

                executeOption(command);
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }


    public void collectionView(String bookOrMovie){
        LibraryCollection currentCollection = bookOrMovie == "book" ?
                bookCollection : movieCollection;
        displayAvailableCollection(currentCollection);
        displayCollectionInstructions(bookOrMovie);

        String command;
        try{
            while(true){
                display(LIBRARY_PROMPT);

                command = reader.readLine();
                checkForQuitRequest(command);

                if (checkForBackRequest(command)) return;
                if (checkForTwoPartsOfCommand(command)) continue;


                 boolean validCommand = executeLibraryCommand(command,currentCollection);
                if(!validCommand) { display(LIBRARY_ERROR); }
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

    private void displayCollectionInstructions(String bookOrMovie) {
        if (bookOrMovie == "book"){
            display(BOOK_COLLECTION_INSTRUCTIONS);
        } else {
            display(MOVIE_COLLECTION_INSTRUCTIONS);
        }
    }

    private void display(Object object){
        if(object instanceof List){
            if( ((List)object).isEmpty()){
                return;
            }
        }
        System.out.println(object.toString());
        System.out.flush();
    }

    private void displayAvailableCollection(LibraryCollection libraryCollection) {
        display(libraryCollection.getLibraryCollection(true));
    }

    private void exit(){
        display(BYE_MSG);
        System.exit(0);
    }

    private boolean checkForTwoPartsOfCommand(String command) {
        if(command.trim().indexOf(" ") == -1){
            display(LIBRARY_ERROR);
            return true;
        }
        return false;
    }

    private void executeOption(String command) {
        if (command.trim().equalsIgnoreCase("List Books")){
            collectionView("book");
            display(mainMenu);
        } else if (command.trim().equalsIgnoreCase("List Movies")){
            collectionView("movie");
            display(mainMenu);
        }
        else if (command.trim().equalsIgnoreCase("List Movies")){
            display(user.toString());
            display(mainMenu);
        }
    }

    private boolean executeLibraryCommand(String command, LibraryCollection currentCollection) {
        String[] commandSplit = command.trim().split(" ", 2);
        String task = commandSplit[0].trim();
        String item = commandSplit[1].trim();

        if (task.equalsIgnoreCase("Checkout")){
            display(currentCollection.checkOutItem(item, customer));
            displayAvailableCollection(currentCollection);
            return true;
        }
        if (task.equalsIgnoreCase("Return")){
            display(currentCollection.returnItem(item));
            displayAvailableCollection(currentCollection);
            return true;
        }
        return false;
    }


    private boolean checkForBackRequest(String command) {
        return command.trim().equalsIgnoreCase("Back");
    }

    private void checkForQuitRequest(String result) {
        if (result.trim().equalsIgnoreCase(QUIT)){
            exit();
        }
    }

    private boolean isValidCustomerName() {
        return customer != null && ValidationHelper.isValidUserID(customer);
    }

    private boolean isValidMainMenuOption(String command) {
        for(String option : mainMenu.getOptions()){
            if (command.trim().equalsIgnoreCase(option)){
                return true;
            }
        }
        return false;
    }


}

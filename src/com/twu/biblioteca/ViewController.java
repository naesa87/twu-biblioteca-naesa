package com.twu.biblioteca;

import com.twu.biblioteca.helpers.StringConstants;
import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.MainMenu;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;

public class ViewController {


    private static final MainMenu mainMenu = new MainMenu();

    private Library library;
    private String customer;
    private BufferedReader reader;

    public ViewController(Library library, BufferedReader reader){
        this.library = library;
        this.reader = reader;
    }

    public void welcomeView(){
        display(StringConstants.WELCOME_MSG.toUpperCase());
        display(StringConstants.QUIT_INSTRUCTION);
        display(StringConstants.NAME_PROMPT);
        try {
            while (true){
                customer = reader.readLine().trim();
                checkForQuitRequest(customer);
                if (isValidCustomerName()){
                    display("Hi " + customer);
                    return;
                }
                display(StringConstants.NAME_ERROR);
                display(StringConstants.NAME_PROMPT);
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
                display(StringConstants.MENU_PROMPT);
                command = reader.readLine();

                checkForQuitRequest(command);
                boolean validOption = isValidMainMenuOption(command);
                if(!validOption) { display(StringConstants.MENU_ERROR); }

                executeOption(command);
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }


    public void libraryView(){
        displayAvailableBooks();
        display(StringConstants.LIBRARY_INSTRUCTIONS);
        String command;
        try{
            while(true){
                display(StringConstants.LIBRARY_PROMPT);

                command = reader.readLine();
                checkForQuitRequest(command);

                if (checkForBackRequest(command)) return;
                if (checkForTwoPartsOfCommand(command)) continue;

                boolean validCommand = executeLibraryCommand(command);
                if(!validCommand) { display(StringConstants.LIBRARY_ERROR); }
            }
        }
        catch (IOException ex){
            System.err.println(ex);
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

    private void displayAvailableBooks() {
        display(library.getlistOfBooks(true));
    }

    private void exit(){
        display(StringConstants.BYE_MSG);
        System.exit(0);
    }

    private boolean checkForTwoPartsOfCommand(String command) {
        if(command.trim().indexOf(" ") == -1){
            display(StringConstants.LIBRARY_ERROR);
            return true;
        }
        return false;
    }

    private void executeOption(String command) {
        if (command.trim().equalsIgnoreCase("List Books")){
            libraryView();
            display(mainMenu);
        }
    }

    private boolean executeLibraryCommand(String command) {
        String[] commandSplit = command.trim().split(" ", 2);
        String task = commandSplit[0].trim();
        String book = commandSplit[1].trim();

        if (task.equalsIgnoreCase("Checkout")){
            display(library.checkOutBook(book, customer));
            displayAvailableBooks();
            return true;
        }
        if (task.equalsIgnoreCase("Return")){
            display(library.returnBook(book));
            displayAvailableBooks();
            return true;
        }
        return false;
    }

    private boolean checkForBackRequest(String command) {
        return command.trim().equalsIgnoreCase("Back");
    }

    private void checkForQuitRequest(String result) {
        if (result.trim().equalsIgnoreCase(StringConstants.QUIT)){
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

package com.twu.biblioteca;

import com.twu.biblioteca.helpers.CommandInterpreter;
import com.twu.biblioteca.helpers.StringHelper;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.MainMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        library = new Library();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        commandInterpreter = new CommandInterpreter();

        welcomeView(reader);
        mainMenuView(reader);

        quit(reader);
    }


    private CommandInterpreter commandInterpreter;
    private static final MainMenu mainMenu = new MainMenu();
    private static final String WELCOME_MSG= "Welcome to Biblioteca!";
    private static final String BYE_MSG = "Thank you. Goodbye!";
    private static final String NAME_PROMPT = "What's your name?:";
    private static final String NAME_ERROR = "(Please type a valid name)";
    private static final String MENU_PROMPT = "Please choose a menu option";
    private static final String MENU_ERROR = "Invalid option";
    private static final String LIBRARY_PROMPT = "Please enter a command";
    private static final String LIBRARY_ERROR = "Invalid library command";
    private static final String LIBRARY_INSTRUCTIONS = "to borrow a book enter: Checkout book name>\n"
            +"to return a book enter: Return book name>\n"+
            "to go back to main menu enter: back";

    private static final String QUIT = "quit";
    private static final List<String> LIBRARY_COMMANDS = Arrays.asList("Checkout","Return");
    private String customer;
    private Library library;

    private void display(Object object){

        if(object instanceof List){
            if( ((List)object).isEmpty()){
                return;
            }
        }
        System.out.println(object.toString());
        System.out.flush();
    }

    private void quit(Reader reader){
        try {
            display(BYE_MSG);
            reader.close();
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }
    private void exit(){
        display(BYE_MSG);
        System.exit(0);
    }

    public void welcomeView(BufferedReader reader){
        display(WELCOME_MSG.toUpperCase());
        display(NAME_PROMPT);
        try {
            while (true){
                customer = reader.readLine();
                checkForQuitRequest(customer);
                if (customer != null && StringHelper.isNotWhitespace(customer)){
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

    private void checkForQuitRequest(String result) {
        if (result.trim().equalsIgnoreCase(QUIT)){
            exit();
        }
    }

    public void mainMenuView(BufferedReader reader){
        display(mainMenu);
        String command;
        try{
            while(true){
                display(MENU_PROMPT);
                command = reader.readLine();
                checkForQuitRequest(command);
                boolean validOption = false;
                for(String option : mainMenu.getOptions()){
                    if (command.trim().equalsIgnoreCase(option)){
                        validOption = true;
                    }
                }
                if(!validOption) { display(MENU_ERROR);}
                if (command.trim().equalsIgnoreCase("List Books")){
                    libraryView(reader);
                    display(mainMenu);
                }
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

    public void libraryView(BufferedReader reader){
        display(library.getlistOfBooks(true));
        display(LIBRARY_INSTRUCTIONS);
        String command;
        try{
            while(true){
                display(LIBRARY_PROMPT);

                command = reader.readLine();
                checkForQuitRequest(command);
                boolean validCommand = false;
                if(command.trim().equalsIgnoreCase("Back")){
                    return;
                }
                if(command.trim().indexOf(" ") == -1){
                    display(LIBRARY_ERROR);
                    continue;
                }
                String[] commandSplit = command.trim().split(" ", 2);
                String task = commandSplit[0].trim();
                String book = commandSplit[1].trim();

                if (task.equalsIgnoreCase("Checkout")){
                    validCommand = true;
                    display(library.checkOutBook(book, customer));
                    display(library.getlistOfBooks(true));
                }
                if (task.equalsIgnoreCase("Return")){
                    validCommand = true;
                    display(library.returnBook(book));
                    display(library.getlistOfBooks(true));
                }
                if(!validCommand) { display(LIBRARY_ERROR);}

            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }


}

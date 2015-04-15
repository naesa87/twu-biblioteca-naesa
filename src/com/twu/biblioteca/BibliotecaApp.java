package com.twu.biblioteca;

import com.twu.biblioteca.helpers.CommandInterpreter;
import com.twu.biblioteca.helpers.StringHelper;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.MainMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
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
    private String customer;

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
                if (customer.equals("quit")){
                    exit();
                }
                if (customer != null && StringHelper.isNotWhitespace(customer)){
                    return;
                }
                display(NAME_ERROR);
                display(NAME_PROMPT);
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
        display("Hi " + customer);
    }

    public void mainMenuView(BufferedReader reader){
        display(mainMenu);
        display(commandInterpreter.getInitialPrompt());
        boolean hasRequestedQuit = false;
        String command;
        List<Object> result = new ArrayList<Object>();
        try{
            while(!hasRequestedQuit){
                command = reader.readLine();
                hasRequestedQuit = commandInterpreter.parseInput(command, result);
                display(result);
                result.clear();
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }
}

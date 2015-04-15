package com.twu.biblioteca.helpers;

import java.util.List;

public class CommandInterpreter {

    public boolean parseInput (String  command, final List result) {
        if (result == null) {
            throw new IllegalArgumentException("Result param cannot be null.");
        }
        if (!result.isEmpty()){
            throw new IllegalArgumentException("Result param must be empty.");
        }
        if (command == null) {
            throw new IllegalArgumentException("Line must not be null.");
        }

        boolean hasRequestedQuit = command.trim().equalsIgnoreCase(QUIT);
        if (!hasRequestedQuit)  {
            try {
                Class theClass = Class.forName(command);
                StringBuilder superclasses = new StringBuilder();
                superclasses.append(HEADER);
                superclasses.append(NEW_LINE);
                while (theClass != null) {
                    superclasses.append(theClass);
                    superclasses.append(NEW_LINE);
                    theClass = theClass.getSuperclass();
                }
                result.add(superclasses);
                result.add(DEFAULT_PROMPT);
            }
            catch (ClassNotFoundException ex){
                //recover by asking the user for corrected input
                result.clear();
                result.add(ERROR_PROMPT);
            }
        }

        assert !result.isEmpty(): "Result must be non-empty.";

        return hasRequestedQuit;
    }

    public String getInitialPrompt(){
        return MENU_PROMPT;
    }

    private static final String MENU_PROMPT = "Please choose a menu option";
    private static final String DEFAULT_PROMPT = "Please enter a class name>";
    private static final String ERROR_PROMPT = "Invalid.  Example:\"java.lang.String\">";
    private static final String HEADER = "The inheritance tree:";
    private static final String QUIT = "quit";
    private static final String NEW_LINE = System.getProperty("line.separator");
}

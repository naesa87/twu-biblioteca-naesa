package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainMenu {

    private static final String MENU_TITLE = "MAIN MENU OPTIONS";
    private List<String> options;

    public MainMenu(){
        this.options = new ArrayList<String>();
        options.add("List Books");
        options.add("List Movies");
        options.add("Account Information");
    }

    public List<String> getOptions(){
        return new ArrayList<String>(options);
    }

    @Override
    public String toString() {
        StringBuilder mainMenuString = new StringBuilder();
        String LS = System.getProperty("line.separator");
        mainMenuString.append(StringHelper.horizontalLine());
        mainMenuString.append(LS);
        mainMenuString.append(MENU_TITLE);
        mainMenuString.append(LS);
        for (Iterator optionIterator = options.iterator(); optionIterator.hasNext();) {
            mainMenuString.append(optionIterator.next());
            if(optionIterator.hasNext()){
                mainMenuString.append(LS);
            }
        }
        mainMenuString.append(LS);
        mainMenuString.append(StringHelper.horizontalLine());
        return mainMenuString.toString();
    }

}

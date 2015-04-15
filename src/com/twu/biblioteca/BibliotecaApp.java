package com.twu.biblioteca;

import com.twu.biblioteca.helpers.StringHelper;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.MainMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        library = new Library();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ViewController viewController = new ViewController(library);
        viewController.welcomeView(reader);
        viewController.mainMenuView(reader);
        viewController.quit(reader);
    }

}

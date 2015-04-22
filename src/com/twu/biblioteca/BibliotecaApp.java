package com.twu.biblioteca;

import com.twu.biblioteca.models.Library;
import java.io.*;


public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        library = new Library();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ViewController viewController = new ViewController(library,reader);
        viewController.welcomeView();
        viewController.mainMenuView();
        viewController.quit();
    }

}

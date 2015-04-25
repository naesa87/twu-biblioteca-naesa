package com.twu.biblioteca;

import com.twu.biblioteca.models.BookCollection;
import java.io.*;


public class BibliotecaApp {

    private BookCollection bookCollection;

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        bookCollection = new BookCollection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ViewController viewController = new ViewController(bookCollection,reader);
        viewController.welcomeView();
        viewController.mainMenuView();
    }

}

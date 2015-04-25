package com.twu.biblioteca;

import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.MovieCollection;
import com.twu.biblioteca.models.UserAccounts;

import java.io.*;


public class BibliotecaApp {

    private BookCollection bookCollection;
    private MovieCollection movieCollection;
    private UserAccounts userAccounts;

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        bookCollection = new BookCollection();
        movieCollection = new MovieCollection();
        userAccounts = new UserAccounts();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ViewController viewController
                = new ViewController(bookCollection,movieCollection,userAccounts,reader);
        viewController.welcomeView();
        viewController.mainMenuView();
    }

}

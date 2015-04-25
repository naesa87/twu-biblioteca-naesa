package com.twu.biblioteca;

import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.MovieCollection;

import java.io.*;


public class BibliotecaApp {

    private BookCollection bookCollection;
    private MovieCollection movieCollection;

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run(){
        bookCollection = new BookCollection();
        movieCollection = new MovieCollection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ViewController viewController = new ViewController(bookCollection,reader);
        viewController.welcomeView();
        viewController.mainMenuView();
    }

}

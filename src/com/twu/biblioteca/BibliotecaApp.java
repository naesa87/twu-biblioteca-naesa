package com.twu.biblioteca;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void loadLibraryWithBookData(){
        // have a separate file with some dummy data then
        // add to available if customer is null, otherwise add to checkedout
        // use add method of library
        Library lib = new Library();
        lib.createBook(" as ","asd",2000,new Customer("sada"));

    }
}

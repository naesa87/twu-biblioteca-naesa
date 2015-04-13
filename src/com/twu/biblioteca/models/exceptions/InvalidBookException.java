package com.twu.biblioteca.models.exceptions;

public class InvalidBookException extends RuntimeException {

    public InvalidBookException() {
        super();
    }

    public InvalidBookException(String s) {
        super(s);
    }

}
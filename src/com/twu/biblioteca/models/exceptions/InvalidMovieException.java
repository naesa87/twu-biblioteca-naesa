package com.twu.biblioteca.models.exceptions;

public class InvalidMovieException extends RuntimeException {

    public InvalidMovieException() {
        super();
    }

    public InvalidMovieException(String s) {
        super(s);
    }

}
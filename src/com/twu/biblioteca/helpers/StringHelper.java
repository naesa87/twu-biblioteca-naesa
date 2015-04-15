package com.twu.biblioteca.helpers;

public class StringHelper {
    public static boolean isNotWhitespace(String string) {
        return string.trim().length() > 0;
    }

    public static String horizontalLine(){
        return "======================================================";
    }
}

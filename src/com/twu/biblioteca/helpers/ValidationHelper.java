package com.twu.biblioteca.helpers;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelper {

    public static boolean isValidYear(int year) {
        return year >= 0 && year <= Calendar.getInstance().get(Calendar.YEAR);
    }

    public static boolean isValidRating(Integer rating){
        if(rating == null){
            return true;
        }
        return ((rating >= 1 && rating <= 10));
    }

    public static boolean isValidUserID(String userID){
        Pattern libraryIDPattern = Pattern.compile("\\d{3}-\\d{4}");
        Matcher libraryIDMatcher = libraryIDPattern.matcher(userID);
        return libraryIDMatcher.matches();
    }
}

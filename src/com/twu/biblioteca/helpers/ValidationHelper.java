package com.twu.biblioteca.helpers;

import java.util.Calendar;

public class ValidationHelper {

    public static boolean isValidYear(int year) {
        return year > 0 && year <= Calendar.getInstance().get(Calendar.YEAR);
    }

    public static boolean isValidRating(int rating){
        return rating >= 0 && rating <= 10;
    }

}

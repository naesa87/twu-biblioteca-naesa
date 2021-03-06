package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ValidationHelper;
import com.twu.biblioteca.models.exceptions.InvalidUserException;

abstract public class LibraryItem {

    protected String name;
    protected String userID;
    protected int year;

    public void setUser(String userID){
        if (userID == null){
            this.userID = null;
            return;
        }
        if (ValidationHelper.isValidUserID(userID)){
            this.userID = userID;
        } else {
            throw new InvalidUserException("User library number must have format XXX-XXXX");
        }
    }

    public String getName(){
        return name;
    }

    public String getUserID(){
        return userID;
    }

    public int getYear(){
        return year;
    }

    public boolean isCheckedOut(){
        return userID != null;
    }


}

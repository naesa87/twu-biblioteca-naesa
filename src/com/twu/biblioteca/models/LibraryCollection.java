package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

abstract public class LibraryCollection<T extends LibraryItem> {

    protected List<T> collection;

    public LibraryCollection(){
        this.collection = new ArrayList<T>();
        // override this
        // // then add loadTempBookData(); //since there is no db yet
    }

    public boolean containsItem(String itemName){
        for(T obj: collection){
            if (itemName.equals(obj.name())){
                return true;
            }
        }
        return false;
    }

    public T getItem(String itemName){
        for(T obj: collection){
            if (itemName.equals(obj.name())){
                return obj;
            }
        }
        return null;
    }

    public boolean isItemAvailable(String itemName){
        T obj = getItem(itemName);
        return !obj.isCheckedOut();
    }

    public abstract String getLibraryCollection(boolean availableFlag);

    public String checkOutItem(String itemName, String userID){

        if (!containsItem(itemName)){
            return "Book does not exist in library";
        }
        if (!isItemAvailable(itemName)){
            return "Book is currently unavailable for checkout";
        }
        try {
            T obj  = getItem(itemName);
            obj.setUser(userID);
        }catch (Exception e){
            return "Book could not be checked out";
        }
        return "Thank you! Enjoy the book" ;
    }

    public String returnItem(String itemName){
        if (!containsItem(itemName)){
            return "Book does not exist in library";
        }
        if (isItemAvailable(itemName)){
            return "Book has already been returned";
        }
        try {
            T obj  = getItem(itemName);
            obj.setUser(null);
        }catch (Exception e){
            return "Book could not be returned";
        }
        return "Thank you for returning the book" ;
    }

}

package com.twu.biblioteca.models;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

abstract public class LibraryCollection<T extends LibraryItem> {

    protected List<T> collection;
    private Class<T> persistentClass;

    public LibraryCollection(){
        this.collection = new ArrayList<T>();
        this.persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        // override this
        // // then add loadTempBookData(); //since there is no db yet
    }

    public boolean containsItem(String itemName){
        for(T obj: collection){
            if (itemName.equalsIgnoreCase(obj.name())){
                return true;
            }
        }
        return false;
    }

    public T getItem(String itemName){
        for(T obj: collection){
            if (itemName.equalsIgnoreCase(obj.name())){
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
            return getClassName()+" does not exist in library";
        }
        if (!isItemAvailable(itemName)){
            return getClassName()+" is currently unavailable for checkout";
        }
        try {
            T obj  = getItem(itemName);
            obj.setUser(userID);
        }catch (Exception e){
            return getClassName()+" could not be checked out";
        }
        return "Thank you! Enjoy the "+getClassName().toLowerCase();
    }

    public String returnItem(String itemName){
        if (!containsItem(itemName)){
            return getClassName()+" does not exist in library";
        }
        if (isItemAvailable(itemName)){
            return getClassName()+" has already been returned";
        }
        try {
            T obj  = getItem(itemName);
            obj.setUser(null);
        }catch (Exception e){
            return getClassName()+"  could not be returned";
        }
        return "Thank you for returning the "+getClassName().toLowerCase();
    }

    private String getClassName(){
        return persistentClass.getSimpleName();
    }

}

package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.helpers.ValidationHelper.isValidUserID;

public class UserAccounts {

    private List<User> listOfUsers;

    public UserAccounts(){
        listOfUsers = new ArrayList<User>();
        loadTempUserData();
    }

    public boolean containsUserID(String userID){
        if (!isValidUserID(userID)){
            return false;
        }
        for (User user : listOfUsers){
            if (user.getUserID().equals(userID)){
                return true;
            }
        }
        return false;
    }

    public User getUserIfValidPassword(String userID, String password){
        for(User user: listOfUsers){
            if (user.getUserID().equals(userID)){
                if (user.getPassword().equals(password)){
                    return user;
                }
            }
        }
        return null;
    }

    private void loadTempUserData(){
        listOfUsers.add(new User("123-1234","password","John Dorian","jd@gmail.com","0420-123-1234"));
        listOfUsers.add(new User("123-1235","asdfasdf","Rachel Green","rg@gmail.com","0420-123-1235"));
        listOfUsers.add(new User("123-1236","p4ssword","Damon Salvatore","ds@gmail.com","0420-123-1236"));
        listOfUsers.add(new User("123-1237","s3condary","John Snow","js@gmail.com","0420-123-1237"));
        listOfUsers.add(new User("123-1238","123456","Matt Murdoch","mm@gmail.com","0420-123-1238"));
    }
}

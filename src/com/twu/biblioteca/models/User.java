package com.twu.biblioteca.models;

public class User {

    private String userID;
    private String password;
    private String fullName;
    private String email;
    private String phone;

    public User(String userID, String password, String fullName, String email, String phone){
        this.userID = userID;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public String getUserID(){
        return userID;
    }

    public String getPassword(){
        return password;
    }

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User user = (User) object;
        return (userID.equals(user.userID)
                && password.equals(user.password)
                && fullName.equals(user.fullName)
                && email.equals(user.email)
                && phone.equals(user.phone));
    }

    @Override
    public int hashCode() {
        final int prime = 31; // a prime for combining hash codes of fields
        int result = 1;
        result = prime * result + userID.hashCode();
        result = prime * result + password.hashCode();
        result = prime * result + fullName.hashCode();
        result = prime * result + email.hashCode();
        result = prime * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "name: "+ fullName + "\nemail: " + email + "\nphone: " + phone;
    }
}

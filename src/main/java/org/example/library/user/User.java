package org.example.library.user;


import org.example.library.item.Item;

import java.io.Serializable;

@SuppressWarnings("unused")
public abstract class User implements Serializable {
    private int userID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private String roles; //enum
    private String permissions; //enum

    public User(String firstName, String lastName, String login, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void rentItem(Item item) {

    }

    public void returnItem(Item item) {

    }

    public void reserveItem(Item item) {

    }
}

package org.example.model.user;


import org.example.model.item.Item;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public abstract class User implements Serializable {

    private static int idCounter = 1;
    private int userID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    protected List<Role> roles;
    protected List<Permission> permissions;

    public User(String firstName, String lastName, String login, String password, String email) {
        this.userID = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;

    }

    public static void  setStaticCounterToOne() {
        idCounter = 1;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public void rentItem(Item item) {

    }

    public void returnItem(Item item) {

    }

    public void reserveItem(Item item) {

    }

    public boolean areCredentialsEqual(String login, String password) {
        return this.getLogin().equals(login) && this.getPassword().equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

}

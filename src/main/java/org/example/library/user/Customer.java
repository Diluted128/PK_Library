package org.example.library.user;

import java.io.Serializable;

public final class Customer extends User implements Serializable {

    public Customer(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                getFirstName() + " " + getLastName() +
                " " + getLogin() +
                "}";
    }
}

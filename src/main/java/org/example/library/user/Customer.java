package org.example.library.user;

import org.example.library.item.Item;

import java.io.Serializable;
import java.util.List;

public final class Customer extends User implements Serializable {

    private List<Item> rentedItems;
    private boolean onBlacklist;
    private double penalty;


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
    public void payPenalty(Double penalty) {

    };
}

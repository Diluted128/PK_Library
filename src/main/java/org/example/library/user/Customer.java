package org.example.library.user;

import org.example.library.item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Customer extends User implements Serializable {

    private List<Item> rentedItems;
    private boolean onBlacklist;
    private double penalty;


    public Customer(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
        this.rentedItems = new ArrayList<>();
        this.onBlacklist = false;
        this.penalty = 0;
    }

    public List<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(List<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public boolean isOnBlacklist() {
        return onBlacklist;
    }

    public void setOnBlacklist(boolean onBlacklist) {
        this.onBlacklist = onBlacklist;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Customer{" +
                getFirstName() + " " + getLastName() +
                " " + getLogin() +
                "}";
    }
    public void payPenalty(Double penalty) {

    }
}

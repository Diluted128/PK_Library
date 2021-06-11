package org.example.model.user;

import org.example.model.item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Customer extends User implements Serializable {

    private List<Item> rentedItems;
    private List<Item> reservedItems;
    private boolean onBlacklist;
    private double penalty;


    public Customer(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
        this.rentedItems = new ArrayList<>();
        this.reservedItems = new ArrayList<>();
        this.onBlacklist = false;
        this.penalty = 0;
        this.roles = List.of(Role.CUSTOMER);
        this.permissions = List.of(Permission.RESERVE, Permission.RENT, Permission.RETURN);
    }

    public List<Item> getRentedItems() {
        return rentedItems;
    }

    public List<Item> getReservedItems() {
        return reservedItems;
    }

    public void addReservedItem(Item item) {
        this.reservedItems.add(item);
    }

    public void removeReservedItem(Item item) {
        this.reservedItems.remove(item);
    }

    public void addRentedItem(Item item) {
        this.rentedItems.add(item);
    }

    public void removeRentedItem(Item item) {
        this.rentedItems.remove(item);
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
        setPenalty(0.0);
    }
}

package org.example.library.user;

import org.example.library.item.Item;

public class Worker extends User{

    public Worker(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
    }

    public void addItem(Item item) {

    }

    public void addToBlacklist(Customer customer) {

    }
}

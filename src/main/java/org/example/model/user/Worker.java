package org.example.model.user;

import org.example.model.item.Item;

import java.util.List;

public class Worker extends User{

    public Worker(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
        this.roles = List.of(Role.WORKER);
        this.permissions = List.of(Permission.PICKUP, Permission.ADD_TO_BLACKLIST, Permission.ADD_ITEM,
                Permission.REMOVE_ITEM, Permission.CONFIRM_RENTAL);
    }

    public void addItem(Item item) {

    }

    public void addToBlacklist(Customer customer) {

    }
}

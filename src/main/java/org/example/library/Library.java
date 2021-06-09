package org.example.library;

import org.example.library.action.Action;
import org.example.library.item.Item;
import org.example.library.user.Customer;
import org.example.library.user.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Customer> blacklist;
    private List<User> users;
    private List<Item> items;
    private List<Action> actions;

    public Library(String name) {
        this.name = name;
        blacklist = new ArrayList<>();
        users = new ArrayList<>();
        items = new ArrayList<>();
        actions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<Customer> blacklist) {
        this.blacklist = blacklist;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void printActions() {
        this.actions.stream()
                .forEach(System.out::println);
    }

}

package org.example.model;

import org.example.model.action.Action;
import org.example.model.item.Item;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(blacklist, library.blacklist) && Objects.equals(users, library.users) && Objects.equals(items, library.items) && Objects.equals(actions, library.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, blacklist, users, items, actions);
    }
}

package org.example.library.user;

import org.example.library.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker{

    private List<Worker> subordinates;

    public Manager(String firstName, String lastName, String login, String password, String email) {
        super(firstName, lastName, login, password, email);
        this.subordinates = new ArrayList<>();
        this.roles = List.of(Role.MANAGER, Role.WORKER);
        this.permissions = List.of(Permission.HIRE, Permission.FIRE,
                Permission.PICKUP, Permission.ADD_TO_BLACKLIST, Permission.ADD_ITEM, Permission.REMOVE_ITEM, Permission.CONFIRM_RENTAL);
    }

    public void removeItem(Item item) {

    }

    public void hireWorker(Worker worker) {

    }

    public void fireWorker(Worker worker) {

    }

    public void assignSubordinate(Worker worker) {
        this.subordinates.add(worker);
    }

}

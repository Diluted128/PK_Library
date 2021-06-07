package org.example.library.user;

import org.example.library.item.Item;

import java.util.List;

public class Manager extends Worker{

    private List<Worker> subordinates;

    public Manager(String firstName, String lastName, String login, String password, String email, List<Worker> subordinates) {
        super(firstName, lastName, login, password, email);
        this.subordinates = subordinates;//
    }

    public void removeItem(Item item) {

    }

    public void hireWorker(Worker worker) {

    }

    public void fireWorker(Worker worker) {

    }
}

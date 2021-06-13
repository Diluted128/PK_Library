package org.example.model.user;

import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.model.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        if(ItemRepository.getItemRepository().removeItemAndReturnIfSuccessful(item)){
            System.out.println("Successful");
        }
        else {
            System.out.println("Something is wrong");
        }
    }

    public void hireWorker(Worker worker) {
        if( UserRepository.getUserRepository().addNewUserAndReturnIfSuccessful(worker))
        {
            System.out.println("Successful");
        }
        else {
            System.out.println("Something is wrong");
        }
      }

    public void fireWorker(Worker worker) {
        if( UserRepository.getUserRepository().removeUserAndReturnIfSuccessful(worker))
        {
            System.out.println("Successful");
        }
        else {
            System.out.println("Something is wrong");
        }
    }

    public void assignSubordinate(Worker worker) {
        this.subordinates.add(worker);
    }

    public List<Worker> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Worker> subordinates) {
        this.subordinates = subordinates;
    }
}

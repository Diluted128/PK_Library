package org.example.model.user;

import org.example.db.ItemRepository;
import org.example.model.Library;
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
        if(ItemRepository.getItemRepository().addNewItemAndReturnIfSuccessful(item)){
            System.out.println("Successful");
        }
        else{
            System.out.println("Something is wrong");
        }
    }

    public void addToBlacklist(Customer customer) {

    }
}

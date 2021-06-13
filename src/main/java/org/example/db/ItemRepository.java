package org.example.db;

import org.example.model.item.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static final File itemsFile = new File("./src/main/java/org/example/db/items.xml");
    private static ItemRepository itemRepository = createSingletonInstance();

    private static ItemRepository createSingletonInstance() {
        try {
            return new ItemRepository();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ItemRepository getItemRepository() {
        return itemRepository;
    }

    public ArrayList<Item> getAllItems() {
        //TODO: change to xml encoder/decoder
        ArrayList<Item> items = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(itemsFile))) {
            items = (ArrayList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public boolean saveItemsToFile(List<Item> items) {
        //TODO: change to xml encoder/decoder
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(items);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean addNewItemAndReturnIfSuccessful(Item newItem) {
        ArrayList<Item> items = getAllItems();
        items.add(newItem);
        return saveItemsToFile(items);
    }

    public boolean addNewItemsAndReturnIfSuccessful(List<Item> newItems) {
        ArrayList<Item> items = getAllItems();
        items.addAll(newItems);
        return saveItemsToFile(items);
    }

    public boolean removeItemAndReturnIfSuccessful(Item item) {
        ArrayList<Item> items = getAllItems();
        items.remove(item);
        return saveItemsToFile(items);
    }

    public boolean removeItemsAndReturnIfSuccessful(List<Item> items) {
        ArrayList<Item> itemList = getAllItems();
        itemList.removeAll(items);
        return saveItemsToFile(items);
    }
}

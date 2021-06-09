package org.example.db;

import org.example.model.item.Item;

import java.io.*;
import java.util.ArrayList;

public class ItemRepository {

    private static final File itemsFile = new File("./src/main/java/org/example/db/items.bin");
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
        ArrayList<Item> items = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(itemsFile))) {
            items = (ArrayList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public boolean addNewItemAndReturnIfSuccessful(Item newItem) {
        ArrayList<Item> items = getAllItems();

        items.add(newItem);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(items);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


}

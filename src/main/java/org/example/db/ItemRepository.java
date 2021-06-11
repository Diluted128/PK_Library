package org.example.db;

import org.example.model.item.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public void saveItemsToFile(List<Item> items) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(items);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

    public boolean addNewItemsAndReturnIfSuccessful(List<Item> newItems) {
        ArrayList<Item> items = getAllItems();

        items.addAll(newItems);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(items);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeItemAndReturnIfSuccessful(Item item) {
        ArrayList<Item> items = getAllItems();

        items.remove(item);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(items);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeItemsAndReturnIfSuccessful(List<Item> items) {
        ArrayList<Item> itemList = getAllItems();

        itemList.removeAll(items);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(itemsFile))) {
            outputStream.writeObject(itemList);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

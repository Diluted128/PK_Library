package org.example.db;

import org.example.model.action.Action;
import org.example.model.item.Article;
import org.example.model.item.Book;
import org.example.model.item.Item;
import org.example.model.item.Newspaper;
import org.example.model.user.Customer;
import org.example.model.user.Manager;
import org.example.model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Item> removeItemById(List<Item> items, Item item) {
        return items.stream().filter(i -> i.getItemID() != item.getItemID()).collect(Collectors.toList());
    }

    public boolean updateItemInfo(Item updatedItem) {
        List<Item> items = getAllItems();

        Item itemToBeUpdated;
        Optional<Item> optionalItem = items.stream().filter(i -> i.getItemID() == updatedItem.getItemID()).findFirst();
        if (optionalItem.isEmpty()) {
            return false;
        }
        itemToBeUpdated = optionalItem.get();


        items = removeItemById(items, itemToBeUpdated);

        itemToBeUpdated.setISBN(updatedItem.getISBN());
        itemToBeUpdated.setIsRented(updatedItem.getIsRented());
        itemToBeUpdated.setIsReserved(updatedItem.getIsReserved());
        itemToBeUpdated.setAuthors(itemToBeUpdated.getAuthors());
        itemToBeUpdated.setNumberOfPages(updatedItem.getNumberOfPages());
        itemToBeUpdated.setTitle(updatedItem.getTitle());
        itemToBeUpdated.setType(updatedItem.getType());

        if (itemToBeUpdated instanceof Book) {
            ((Book) itemToBeUpdated).setCover(((Book) itemToBeUpdated).getCover());
            ((Book) itemToBeUpdated).setGenre(((Book) itemToBeUpdated).getGenre());
            ((Book) itemToBeUpdated).setPublisher(((Book) itemToBeUpdated).getPublisher());
        }
        if (itemToBeUpdated instanceof Article) {
            ((Article) itemToBeUpdated).setArticleType(((Article) itemToBeUpdated).getArticleType());
        }
        if (itemToBeUpdated instanceof Newspaper) {
            ((Newspaper) itemToBeUpdated).setPublishingFrequency(((Newspaper) itemToBeUpdated).getPublishingFrequency());
        }

        items.add(itemToBeUpdated);
        return true;
    }

}

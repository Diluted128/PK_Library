package org.example.model.item;

import java.io.Serializable;
import java.util.List;

public abstract class Item implements Serializable {

    private List<String> authors;
    private String title;
    private int numberOfPages;
    private int itemID;
    private String type;
    private String ISBN;
    private boolean isRented;
    private boolean isReserved;
    private static int counter = 1;

    public Item(List<String> authors, String title, String type, int numberOfPages, String ISBN) {
        this.authors = authors;
        this.title = title;
        this.type = type;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        isRented = false;
        isReserved = false;
        itemID = counter++;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}

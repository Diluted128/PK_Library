package org.example.library.item;

import java.io.Serializable;
import java.util.List;

public abstract class Item implements Serializable {

    private List<String> authors;
    private String title;
    private int numberOfPages;
    private int itemID;
    private String ISBN;
    private boolean isRented;
    private boolean isReserved;
    private static int counter = 0;

    public Item(List<String> authors, String title, int numberOfPages, String ISBN) {
        this.authors = authors;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        isRented = false;
        isReserved = false;
        itemID = counter++;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthor(List<String> authors) {
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

    public void setAuthors(List<String> authors) {
        this.authors = authors;
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

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}

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

    public Item(List<String> authors, String title, int numberOfPages) {
        this.authors = authors;
        this.title = title;
        this.numberOfPages = numberOfPages;
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
}

package org.example.library.item;

import java.util.List;

public abstract class Item {

    private List<String> authors;
    private String title;
    private int numberOfPages;

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

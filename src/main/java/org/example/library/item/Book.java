package org.example.library.item;

import java.util.List;

public class Book extends Item {

    private String publisher;
    private Cover cover;
    private Genre genre;

    public Book(List<String> authors, String title, int numberOfPages, String publisher, Cover cover, Genre genre) {
        super(authors, title, numberOfPages);
        this.publisher = publisher;
        this.cover = cover;
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

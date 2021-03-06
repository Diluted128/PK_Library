package org.example.model.item;

import java.util.List;

public class Book extends Item {

    private String publisher;
    private Cover cover;
    private Genre genre;

    public Book(List<String> authors, String title, int numberOfPages, String ISBN, String publisher, Cover cover, Genre genre) {
        super(authors, title, "Book", numberOfPages, ISBN);
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

    @Override
    public String toString() {
        return String.format("%s, written by %s", getTitle(), getAuthors());
    }
}

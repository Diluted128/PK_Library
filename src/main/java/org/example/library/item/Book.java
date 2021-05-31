package org.example.library.item;

import java.util.List;

public class Book extends Item {

    private String publisher;
    private Cover cover;
    private Long ISBN;
    private Genre genre;

    public Book(List<String> authors, String title, int numberOfPages, String publisher, Cover cover, Long ISBN, Genre genre) {
        super(authors, title, numberOfPages);
        this.publisher = publisher;
        this.cover = cover;
        this.ISBN = ISBN;
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

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

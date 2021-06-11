package org.example.model.item;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private List<String> authors;
    private String title;
    private int numberOfPages;
    private int itemID;
    private String type;
    private String ISBN;
    private boolean isRented;
    private boolean isReserved;
    private String publisher;
    private Cover cover;
    private Genre genre;
    private ArticleType articleType;
    private PublishingFrequency publishingFrequency;

    public ItemDTO(Item item) {
        this.authors = item.getAuthors();
        this.title = item.getTitle();
        this.numberOfPages = item.getNumberOfPages();
        this.itemID = item.getItemID();
        this.type = item.getType();
        this.ISBN = item.getISBN();
        this.isRented = item.getIsRented();
        this.isReserved = item.getIsReserved();

        if (item instanceof Book) {
            this.publisher = ((Book)item).getPublisher();
            this.cover = ((Book)item).getCover();
            this.genre = ((Book)item).getGenre();
        } else {
            this.publisher = "X";
            this.cover = Cover.X;
            this.genre = Genre.X;
        }

        if (item instanceof Article) {
            this.articleType = ((Article)item).getArticleType();
        } else {
            this.articleType = ArticleType.X;
        }

        if (item instanceof Newspaper) {
            this.publishingFrequency = ((Newspaper)item).getPublishingFrequency();
        } else {
            this.publishingFrequency = PublishingFrequency.X;
        }
    }

    public static List<ItemDTO> getList(List<Item> items) {
        List<ItemDTO> itemsDTO = new ArrayList<>();
        for (Item i : items) {
            itemsDTO.add(new ItemDTO(i));
        }
        return itemsDTO;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
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

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public PublishingFrequency getPublishingFrequency() {
        return publishingFrequency;
    }

    public void setPublishingFrequency(PublishingFrequency publishingFrequency) {
        this.publishingFrequency = publishingFrequency;
    }
}

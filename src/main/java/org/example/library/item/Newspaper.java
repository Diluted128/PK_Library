package org.example.library.item;

import java.util.List;

public class Newspaper extends Item {

    private PublishingFrequency publishingFrequency;

    public Newspaper(List<String> authors, String title, int numberOfPages, String ISBN, PublishingFrequency publishingFrequency) {
        super(authors, title, numberOfPages, ISBN);
        this.publishingFrequency = publishingFrequency;
    }

    public PublishingFrequency getPublishingFrequency() {
        return publishingFrequency;
    }

    public void setPublishingFrequency(PublishingFrequency publishingFrequency) {
        this.publishingFrequency = publishingFrequency;
    }
}

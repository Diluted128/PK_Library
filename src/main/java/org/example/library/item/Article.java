package org.example.library.item;

import java.util.List;

public class Article extends Item {

    private ArticleType articleType;

    public Article(List<String> authors, String title, int numberOfPages, ArticleType articleType) {
        super(authors, title, numberOfPages);
        this.articleType = articleType;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }
}

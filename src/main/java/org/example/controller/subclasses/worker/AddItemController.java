package org.example.controller.subclasses.worker;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.controller.abstraction.WorkerController;
import org.example.db.ItemRepository;
import org.example.model.item.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class AddItemController extends WorkerController implements Initializable {


    @FXML
    private TextField BookTitle;
    @FXML
    private TextField BookAuthors;
    @FXML
    private TextField BookPages;
    @FXML
    private TextField BookISBN;
    @FXML
    private TextField BookPublisher;
    @FXML
    private ChoiceBox<String> BookCover;
    @FXML
    private ChoiceBox<String> BookGenre;


    @FXML
    private TextField ArticleTitle;
    @FXML
    private TextField ArticleAuthors;
    @FXML
    private TextField ArticlePages;
    @FXML
    private TextField ArticleISBN;
    @FXML
    private ChoiceBox<String> ItemArticleType;

    @FXML
    private TextField NewTitle;
    @FXML
    private TextField NewAuthors;
    @FXML
    private TextField NewPages;
    @FXML
    private TextField NewISBN;
    @FXML
    private ChoiceBox<String> NewPublishingFreq;

    private ItemRepository itemRepository = new ItemRepository();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> bookCovers =  new ArrayList<>();
        bookCovers.add("PAPERBACK");
        bookCovers.add("HALF_HARD");
        bookCovers.add("HARD");

        ArrayList<String> bookGenre =  new ArrayList<>();
        bookGenre.add("SCI_FI");
        bookGenre.add("HORROR");
        bookGenre.add("HORROR");
        bookGenre.add("BIOGRAPHY");
        bookGenre.add("HISTORY");
        bookGenre.add("ACTION");
        bookGenre.add("CLASSIC");
        bookGenre.add("ROMANCE");

        ArrayList<String> articleType = new ArrayList<>();
        articleType.add("CASE_STUDY");
        articleType.add("REVIEW");
        articleType.add("RESEARCH");
        articleType.add("REPORT");
        articleType.add("POPULAR_SCIENCE");
        articleType.add("ESSAY");

        ArrayList<String> publishingFreg = new ArrayList<>();

        publishingFreg.add("DAY");
        publishingFreg.add("WEEK");
        publishingFreg.add("TWO_WEEKS");
        publishingFreg.add("MONTH");
        publishingFreg.add("QUARTER");
        publishingFreg.add("HALF_YEAR");
        publishingFreg.add("YEAR");

        BookCover.getItems().addAll(bookCovers);
        BookGenre.getItems().addAll(bookGenre);
        ItemArticleType.getItems().addAll(articleType);
        NewPublishingFreq.getItems().addAll(publishingFreg);
    }
    public void addBook(){

        Book newBook = new Book(
                Arrays.asList(BookAuthors.getText().split(",")),
                BookTitle.getText(),
                Integer.parseInt(BookPages.getText()),
                BookISBN.getText(),
                BookPublisher.getText(),
                Cover.valueOf(BookCover.getValue()),
                Genre.valueOf(BookGenre.getValue())
                );


        itemRepository.addNewItemAndReturnIfSuccessful(newBook);

    }
    public void addArticle(){

        Article newArticle = new Article(
                Arrays.asList(ArticleAuthors.getText().split(",")),
                ArticleTitle.getText(),
                Integer.parseInt(ArticlePages.getText()),
                ArticleISBN.getText(),
                ArticleType.valueOf(ItemArticleType.getValue())
        );


        itemRepository.addNewItemAndReturnIfSuccessful(newArticle);

    }
    public void addNewspaper(){

        Newspaper newNewspaper = new Newspaper(
                Arrays.asList(NewAuthors.getText().split(",")),
                NewTitle.getText(),
                Integer.parseInt(NewPages.getText()),
                NewISBN.getText(),
                PublishingFrequency.valueOf(NewPublishingFreq.getValue())
        );

        itemRepository.addNewItemAndReturnIfSuccessful(newNewspaper);

    }
}

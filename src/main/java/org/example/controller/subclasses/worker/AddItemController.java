package org.example.controller.subclasses.worker;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.controller.abstraction.WorkerController;
import org.example.db.ItemRepository;
import org.example.model.item.*;

import java.util.Arrays;


public class AddItemController extends WorkerController {

    @FXML
    private TextField BookID;
    @FXML
    private TextField BookTitle;
    @FXML
    private TextField BookAuthors;
    @FXML
    private TextField BookPages;
    @FXML
    private TextField BookISBN;
    @FXML
    private TextField BookReservation;
    @FXML
    private TextField BookRental;
    @FXML
    private TextField BookPublisher;
    @FXML
    private TextField BookCover;
    @FXML
    private TextField BookGenre;


    @FXML
    private TextField ArticleID;
    @FXML
    private TextField ArticleTitle;
    @FXML
    private TextField ArticleAuthors;
    @FXML
    private TextField ArticlePages;
    @FXML
    private TextField ArticleISBN;
    @FXML
    private TextField ArticleReservation;
    @FXML
    private TextField ArticleRental;
    @FXML
    private TextField ItemArticleType;

    @FXML
    private TextField NewID;
    @FXML
    private TextField NewTitle;
    @FXML
    private TextField NewAuthors;
    @FXML
    private TextField NewPages;
    @FXML
    private TextField NewISBN;
    @FXML
    private TextField NewReservation;
    @FXML
    private TextField NewRental;
    @FXML
    private TextField NewPublishingFreq;

    private ItemRepository itemRepository = new ItemRepository();


    public void addBook(){

        Book newBook = new Book(
                Arrays.asList(BookAuthors.getText().split(",")),
                BookTitle.getText(),
                Integer.parseInt(BookPages.getText()),
                BookISBN.getText(),
                BookPublisher.getText(),
                Cover.valueOf(BookCover.getText()),
                Genre.valueOf(BookGenre.getText())
                );


        itemRepository.addNewItemAndReturnIfSuccessful(newBook);



    }
    public void addArticle(){

        Article newArticle = new Article(
                Arrays.asList(ArticleAuthors.getText().split(",")),
                ArticleTitle.getText(),
                Integer.parseInt(ArticlePages.getText()),
                ArticleISBN.getText(),
                ArticleType.valueOf(ItemArticleType.getText())
        );


        itemRepository.addNewItemAndReturnIfSuccessful(newArticle);

    }
    public void addNewspaper(){

        Newspaper newNewspaper = new Newspaper(
                Arrays.asList(NewAuthors.getText().split(",")),
                NewTitle.getText(),
                Integer.parseInt(NewPages.getText()),
                NewISBN.getText(),
                PublishingFrequency.valueOf(NewPublishingFreq.getText())
        );

        itemRepository.addNewItemAndReturnIfSuccessful(newNewspaper);

    }


}

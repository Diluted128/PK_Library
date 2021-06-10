package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class AddItemController extends Controller {

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
    private TextField ArticleType;
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


    public void addBook(){

    }
    public void addArticle(){

    }
    public void addNewspaper(){

    }
    public void changeSceneToAddItem(ActionEvent event) throws IOException {
        changeScene(event, "[3] AddItemScene.fxml", AddItemController.class);
    }

    public void changeSceneToRemoveItem(ActionEvent event) throws IOException {
        changeScene(event, "[3] RemoveItemScene.fxml", RemoveItemController.class);
    }

    public void changeSceneToConfirmRental(ActionEvent event) throws IOException {
        changeScene(event, "[3] ConfirmRentalScene.fxml", ConfirmRentalController.class);
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        changeScene(event, "[3] MyProfileScene.fxml", MyCustomerProfileController.class);
    }

    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }

}

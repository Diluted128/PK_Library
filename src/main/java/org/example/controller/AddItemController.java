package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.user.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddItemController {

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
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[3] AddItemScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToRemoveItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[3] RemoveItemScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToConfirmRental(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[3] ConfirmRentalScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[3] MyProfileScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }
    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[1] LoginScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }
    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

}

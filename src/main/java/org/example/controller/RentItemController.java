package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentItemController {
    @FXML
    private JFXButton rentItemButton;
    @FXML
    private TextField IdField;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TableView<Item> items;
    @FXML
    private TableColumn<Item,Integer> ID;
    @FXML
    private TableColumn<Item,String> type;
    @FXML
    private TableColumn<Item,String> title;
    @FXML
    private TableColumn<Item, List<String>> authors;
    @FXML
    private TableColumn<Item, Integer> pages;
    @FXML
    private TableColumn<Item,String> ISBN;
    @FXML
    private TableColumn<Item, Boolean> isReserved;
    @FXML
    private TableColumn<Item, Boolean> isRented;
    @FXML
    private TableColumn<Item, String> publisher;
    @FXML
    private TableColumn<Item, Genre> genre;
    @FXML
    private TableColumn<Item, ArticleType> articleType;


    private User loggedInUser;

    public void setTableView(){

        ID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
        pages.setCellValueFactory(new PropertyValueFactory<>("numberOfPages"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        isReserved.setCellValueFactory(new PropertyValueFactory<>("isReserved"));
        isRented.setCellValueFactory(new PropertyValueFactory<>("isRented"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        articleType.setCellValueFactory(new PropertyValueFactory<>("articleType"));

        List<Item> customerItems = new ArrayList<>();
        if(loggedInUser instanceof Customer){
            customerItems = ((Customer)loggedInUser).getRentedItems();
        }
        ObservableList<Item> observableItems = FXCollections.observableArrayList();
        observableItems.addAll(customerItems);
        items.setItems(observableItems);

    }

    public void changeSceneToMyItems(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] MyItemsScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToRentItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] RentItemScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] MyProfileScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] SettingsScene.fxml"));
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

    public void rentItem() {
        //"Incorrect ID"
    }
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        setTableView();
    }
    public String getIdField() {
        return IdField.getText();
    }
}

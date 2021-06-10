package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyItemsController extends Controller {

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
    @FXML
    private Label rentedBooks;
    @FXML
    private Label rentedArticles;
    @FXML
    private Label rentedNewspapers;


    public void changeSceneToMyItems(ActionEvent event) throws IOException {
        changeScene(event, "[2] MyItemsScene.fxml", MyItemsController.class);
    }

    public void changeSceneToRentItem(ActionEvent event) throws IOException {
        changeScene(event, "[2] RentItemScene.fxml", RentItemController.class);
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        changeScene(event, "[2] MyProfileScene.fxml", MyCustomerProfileController.class);
    }

    public void changeSceneToSettings(ActionEvent event) throws IOException {
        changeScene(event, "[2] SettingsScene.fxml", SettingsController.class);
    }

    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        changeScene(event, "[1] LoginScene.fxml", SignoutController.class);
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        setTableView();
    }


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

        this.rentedBooks.setText(String.valueOf(customerItems
                .stream()
                .filter(i -> i.getType().equals("Book"))
                .collect(Collectors.toList()).size()));

        this.rentedArticles.setText(String.valueOf(customerItems
                .stream()
                .filter(i -> i.getType().equals("Article"))
                .collect(Collectors.toList()).size()));

        this.rentedNewspapers.setText(String.valueOf(customerItems
                .stream()
                .filter(i -> i.getType().equals("Newspaper"))
                .collect(Collectors.toList()).size()));

    }

}

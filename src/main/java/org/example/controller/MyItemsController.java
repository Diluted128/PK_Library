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
import org.example.model.item.Item;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyItemsController {

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
    private Label rentedBooks;
    @FXML
    private Label rentedArticles;
    @FXML
    private Label rentedNewspapers;

    private User loggedInUser;

    public void setTableView(){
        // if(item instanceof Book) {

        ID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
        pages.setCellValueFactory(new PropertyValueFactory<>("numberOfPages"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        isReserved.setCellValueFactory(new PropertyValueFactory<>("isReserved"));
        isRented.setCellValueFactory(new PropertyValueFactory<>("isRented"));
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
    public void changeSceneToMyItems(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] MyItemsScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToRentItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[2] RentItemScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/[2] MyProfileScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();

        MyCustomerProfileController myCustomerProfileController = fxmlLoader.getController();
        myCustomerProfileController.setLoggedInUser(loggedInUser);

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

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        setTableView();
    }
    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }
}

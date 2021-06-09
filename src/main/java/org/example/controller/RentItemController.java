package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RentItemController {
    @FXML
    private JFXButton rentItemButton;
    @FXML
    private TextField IdField;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TableColumn<String,String> ID;
    @FXML
    private TableColumn<String,String> Type;
    @FXML
    private TableColumn<String,String> Title;
    @FXML
    private TableColumn<String,String> Authors;
    @FXML
    private TableColumn<String,String> Pages;
    @FXML
    private TableColumn<String,String> ISBN;
    @FXML
    private TableColumn<String,String> Reservation;
    @FXML
    private TableColumn<String,String> Rental;

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

    public String getIdField() {
        return IdField.getText();
    }
}

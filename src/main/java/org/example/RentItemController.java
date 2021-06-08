package org.example;

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
        Parent root = FXMLLoader.load(getClass().getResource("[2] MyItemsScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToRentItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[2] RentItemScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[2] MyProfileScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[2] SettingsScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[1] LoginScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }
}

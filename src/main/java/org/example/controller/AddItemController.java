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

public class AddItemController {

    @FXML
    private TextField ID;
    @FXML
    private TextField Type;
    @FXML
    private TextField Title;
    @FXML
    private TextField Authors;
    @FXML
    private TextField Pages;
    @FXML
    private TextField ISBN;
    @FXML
    private TextField Reservation;
    @FXML
    private TextField Rental;

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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/[3] ConfirmRentalScene.fxml"));
        Parent root = fxmlLoader.load();
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToPickUpItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[3] PickupItemScene.fxml"));
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
    public void addItem(){

    }
    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

}

package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveItemController {
    @FXML
    private TextField ID;

    public void changeSceneToAddItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[3] AddItemScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToRemoveItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[3] RemoveItemScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToConfirmRental(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("[3] ConfirmRentalScene.fxml"));
        Parent root = fxmlLoader.load();

        MyCustomerProfileController myCustomerProfileController = fxmlLoader.getController();
        //  myProfileController.setLoggedInUser(loggedInUser);

        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToPickUpItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[3] PickupItemScene.fxml"));
        Scene LoginReminder = new Scene(root);
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }

    public void changeSceneToMyProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("[3] MyProfileScene.fxml"));
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
    public void removeItem(){

    }
}

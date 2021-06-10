package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyWorkerProfileController extends Controller {

    public void changeSceneToAddItem(ActionEvent event) throws IOException {
        changeScene(event, "[3] AddItemScene.fxml", AddItemController.class);
    }

    public void changeSceneToRemoveItem(ActionEvent event) throws IOException {
        changeScene(event, "[3] RemoveItemScene.fxml", RentItemController.class);
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

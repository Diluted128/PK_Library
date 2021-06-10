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
    private TextField IDField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorsField;
    @FXML
    private TextField pagesField;
    @FXML
    private TextField ISBNField;
    @FXML
    private TextField isReservedField;
    @FXML
    private TextField isRentedField;

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
    public void addItem(){

    }

}

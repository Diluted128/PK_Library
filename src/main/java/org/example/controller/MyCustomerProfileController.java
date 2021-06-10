package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.io.IOException;

public class MyCustomerProfileController extends Controller{
    @FXML
    private Label firstNameField;
    @FXML
    private Label lastNameField;
    @FXML
    private Label userNameField;
    @FXML
    private Label emailField;
    @FXML
    private Label balanceField;
    @FXML
    private JFXButton payPenalty;

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
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }
    public void payPenalty(){

    }

    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        this.firstNameField.setText(user.getFirstName());
        this.lastNameField.setText(user.getLastName());
        this.userNameField.setText(user.getLogin());
        this.emailField.setText(user.getEmail());
        if (user instanceof Customer) {
            this.balanceField.setText(String.valueOf(((Customer) user).getPenalty()));
        } else {
            this.balanceField.setText("0.0");
        }
    }

}

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

public class MyCustomerProfileController {
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

    private User loggedInUser;

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
    public void payPenalty(){

    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
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
    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }
}

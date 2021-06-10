package org.example.controller.subclasses.worker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.controller.abstraction.Controller;
import org.example.controller.abstraction.WorkerController;
import org.example.controller.subclasses.customer.MyCustomerProfileController;
import org.example.controller.subclasses.customer.RentItemController;
import org.example.controller.subclasses.home.LoginSceneController;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.io.IOException;

public class MyWorkerProfileController extends WorkerController {

    @FXML
    private Label firstNameField;
    @FXML
    private Label lastNameField;
    @FXML
    private Label userNameField;
    @FXML
    private Label emailField;

    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        this.firstNameField.setText(user.getFirstName());
        this.lastNameField.setText(user.getLastName());
        this.userNameField.setText(user.getLogin());
        this.emailField.setText(user.getEmail());
    }


}

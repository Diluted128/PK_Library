package org.example.controller.subclasses.customer;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.controller.abstraction.CustomerController;
import org.example.model.user.Customer;
import org.example.model.user.User;

public class MyCustomerProfileController extends CustomerController {
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

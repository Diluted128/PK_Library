package org.example.controller.subclasses.worker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.controller.abstraction.Controller;
import org.example.controller.abstraction.WorkerController;
import org.example.controller.subclasses.customer.MyCustomerProfileController;
import org.example.controller.subclasses.home.LoginSceneController;

import java.io.IOException;

public class RemoveItemController extends WorkerController {
    @FXML
    private TextField ID;



    public void removeItem(){
    //"Incorrect ID"
    }


    public String getID() {
        return ID.getText();
    }
}

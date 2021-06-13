package org.example.controller.subclasses.worker;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.controller.abstraction.WorkerController;

public class RemoveItemController extends WorkerController {
    @FXML
    private TextField ID;

    public void removeItem(){
    //"Incorrect ID exception"
    }


    public String getID() {
        return ID.getText();
    }
}

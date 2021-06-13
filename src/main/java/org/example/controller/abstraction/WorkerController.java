package org.example.controller.abstraction;

import javafx.event.ActionEvent;
import org.example.controller.subclasses.worker.AddItemController;
import org.example.controller.subclasses.worker.ConfirmRentalController;
import org.example.controller.subclasses.worker.RemoveItemController;
import org.example.customer.MyCustomerProfileController;
import org.example.controller.subclasses.home.LoginSceneController;

import java.io.IOException;

public abstract class WorkerController extends Controller {

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

}

package org.example.controller.abstraction;

import javafx.event.ActionEvent;
import org.example.controller.*;
import org.example.controller.subclasses.customer.MyCustomerProfileController;
import org.example.controller.subclasses.customer.MyItemsController;
import org.example.controller.subclasses.customer.RentItemController;
import org.example.controller.subclasses.customer.SettingsController;

import java.io.IOException;

public abstract class CustomerController extends Controller {

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
        changeScene(event, "[1] LoginScene.fxml", SignoutController.class);
    }

}

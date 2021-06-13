package org.example.controller.abstraction;

import javafx.event.ActionEvent;
import org.example.controller.subclasses.manager.FireWorkerController;
import org.example.controller.subclasses.manager.HireWorkerController;
import org.example.controller.subclasses.home.LoginSceneController;
import org.example.db.UserRepository;

import java.io.IOException;

public abstract class ManagerController extends Controller {

    protected UserRepository userRepository = new UserRepository();

    public void changeSceneHireWorker(ActionEvent event) throws IOException {
        changeScene(event, "[4] HireWorkerScene.fxml", HireWorkerController.class);
    }

    public void changeSceneToFireWorker(ActionEvent event) throws IOException {
        changeScene(event, "[4] FireWorkerScene.fxml", FireWorkerController.class);
    }

    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }

}

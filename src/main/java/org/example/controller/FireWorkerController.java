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

public class FireWorkerController extends Controller {
    @FXML
    private TextField workerID;

    public void changeSceneHireWorker(ActionEvent event) throws IOException {
        changeScene(event, "[4] HireWorkerScene.fxml", HireWorkerController.class);
    }

    public void changeSceneToFireWorker(ActionEvent event) throws IOException {
        changeScene(event, "[4] FireWorkerScene.fxml", FireWorkerController.class);
    }
    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }
    public void fireWorker(){

    }

}

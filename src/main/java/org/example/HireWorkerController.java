package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HireWorkerController {
    @FXML
    private TextField ID;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void changeSceneHireWorker(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/[4] HireWorkerScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }

    public void changeSceneToFireWorker(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/[4] FireWorkerScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }
    public void changeSceneToSignOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/[1] LoginScene.fxml"));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        setScene(root,ourStage);
    }
    public void hireWorker(){

    }
    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }
}

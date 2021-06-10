package org.example.controller.subclasses.manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.controller.abstraction.Controller;
import org.example.controller.abstraction.ManagerController;
import org.example.controller.abstraction.WorkerController;
import org.example.controller.subclasses.home.LoginSceneController;

import java.io.IOException;

public class HireWorkerController extends ManagerController {
    @FXML
    private TextField WorkerID;
    @FXML
    private TextField WorkerFirstName;
    @FXML
    private TextField WorkerLastName;
    @FXML
    private TextField WorkerEmail;
    @FXML
    private TextField WorkerLogin;
    @FXML
    private TextField WorkerPassword;



}

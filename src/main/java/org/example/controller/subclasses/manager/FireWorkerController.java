package org.example.controller.subclasses.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.controller.abstraction.Controller;
import org.example.controller.abstraction.ManagerController;
import org.example.controller.abstraction.WorkerController;
import org.example.controller.subclasses.home.LoginSceneController;
import org.example.db.ActionRepository;
import org.example.db.UserRepository;
import org.example.model.item.Item;
import org.example.model.item.ItemDTO;
import org.example.model.user.User;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FireWorkerController extends ManagerController {
    @FXML
    private TextField workerID;
    @FXML
    private TableView<User> workersTable;
    @FXML
    private TableColumn<User,String> WorkerID;
    @FXML
    private TableColumn<User,String> WorkerFirstName;
    @FXML
    private TableColumn<User,String> WorkerLastName;
    @FXML
    private TableColumn<User,String> WorkerEmail;
    @FXML
    private TableColumn<User,String> WorkerLogin;
    @FXML
    private TableColumn<User,String> WorkerPassword;


    public void fireWorker(){

    }
    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        setTableView();
    }
    public void setTableView(){

       // WorkerID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        WorkerFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        WorkerLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        WorkerEmail.setCellValueFactory(new PropertyValueFactory<>("login"));
        WorkerLogin.setCellValueFactory(new PropertyValueFactory<>("password"));
        WorkerPassword.setCellValueFactory(new PropertyValueFactory<>("email"));


        ObservableList<User> observableItems = FXCollections.observableArrayList();
        observableItems.addAll(UserRepository.getUserRepository().returnAllWorkers());
        workersTable.setItems(observableItems);

    }
}

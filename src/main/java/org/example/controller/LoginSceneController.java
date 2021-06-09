package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.model.user.Customer;
import org.example.model.user.Manager;
import org.example.model.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class LoginSceneController {

    @FXML
    private AnchorPane ap;
    @FXML
    private JFXTextArea LoginEmail;
    @FXML
    private JFXTextArea LoginPassword;
    @FXML
    private Label WarnningEmpty;
    @FXML
    private JFXButton LoginButton;
    @FXML
    private JFXButton ForgotPasword;
    @FXML
    private JFXButton SignupButton;


    String passedLogin;
    String passedPassword;

    UserRepository userRepository = new UserRepository();

    public void ForgotPasswordFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[1] PasswordReminderScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }
    public void SignUpFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[1] CreateAccountScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }
    //-----------------------------------------------------------------------
    public void LoginButtonFunctions(ActionEvent event) throws IOException {

        passedLogin = LoginEmail.getText();
        passedPassword = LoginPassword.getText();

        ArrayList<User> usersList = userRepository.getAllUsers();
        User loggedInUser = null;

        Optional<User> foundUser = usersList.stream()
                .filter(u -> u.areCredentialsEqual(passedLogin, passedPassword))
                .findFirst();

        if (foundUser.isPresent()) {
            loggedInUser = foundUser.get();
        }


        System.out.println("Login: " + passedLogin + " Password: " + passedPassword);

        if (loggedInUser == null || passedLogin.equals("") || passedPassword.equals("")) {
            Thread th = new Thread(new bg_Thread());
            th.start();
        }
        else {

            FXMLLoader fxmlLoader;
            Parent root;
            if(loggedInUser instanceof Customer){
               fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/[2] MyItemsScene.fxml"));
               root =  fxmlLoader.load();
                MyItemsController myItemsController = fxmlLoader.getController();
                myItemsController.setLoggedInUser(loggedInUser);
            }
            else if(loggedInUser instanceof Manager){
                fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/[4] HireWorkerScene.fxml"));
                root =  fxmlLoader.load();

              MyItemsController myItemsController = fxmlLoader.getController();
              myItemsController.setLoggedInUser(loggedInUser);
            }
            else{
                fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/[3] AddItemScene.fxml"));
                root =  fxmlLoader.load();
            }

            Scene LoginReminder = new Scene(root);
            Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            ourStage.setScene(LoginReminder);
            ourStage.show();
        }
    }
    class bg_Thread implements Runnable{

        @Override
        public void run() {
            WarnningEmpty.setVisible(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WarnningEmpty.setVisible(false);
        }
    }
}

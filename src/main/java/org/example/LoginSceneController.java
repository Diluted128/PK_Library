package org.example;

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
import org.example.library.user.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


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

    public void ForgotPasswordFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("[1] PasswordReminderScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }
    public void SignUpFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("[1] CreateAccountScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }
    //-----------------------------------------------------------------------
    public void LoginButtonFunctions(ActionEvent event) throws IOException {

        passedLogin = LoginEmail.getText();
        passedPassword = LoginPassword.getText();

        ArrayList<User> usersList = new ArrayList<>();
        User loggedInUser = null;

        if(new File("users.bin").exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("users.bin"))) {
                usersList = (ArrayList) inputStream.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (User u : usersList) {
            if (u.areCredentialsEqual(passedLogin, passedPassword)) {
                loggedInUser = u;
                break;
            }
        }



        System.out.println("Login: " + passedLogin + " Password: " + passedPassword);

        if (loggedInUser == null || passedLogin.equals("") || passedPassword.equals("")) {
            Thread th = new Thread(new bg_Thread());
            th.start();
        } else {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("[2] MyItemsScene.fxml"));
            Parent root = fxmlLoader.load();

            MyItemsController myItemsController = fxmlLoader.getController();
            myItemsController.setLoggedInUser(loggedInUser);

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

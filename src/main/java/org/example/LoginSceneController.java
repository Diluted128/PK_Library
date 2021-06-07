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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


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

        System.out.println("Login: " + passedLogin + " Password: " + passedPassword);

        if (passedLogin.equals("") || passedPassword.equals("")) {
            Thread th = new Thread(new bg_Thread());
            th.start();
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("[2] WelcomeScene.fxml"));
            Scene LoginReminder = new Scene(root);

            Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            ourStage.setX(260);
            ourStage.setY(60);
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

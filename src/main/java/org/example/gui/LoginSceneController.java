package org.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginSceneController implements Initializable {

    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private TextField LoginEmail;
    @FXML
    private TextField LoginPassword;
    @FXML
    private Label WarnningEmpty;


    String passedLogin;
    String passedPassword;


    public void ForgotPasswordFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PasswordReminderScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }
    //-----------------------------------------------------------------------
    public void initialize(URL arg0, ResourceBundle arg1){
         myProgressBar.setProgress(0.0);
    }
    public void LoginButtonFunctions() {

        passedLogin = LoginEmail.getText();
        passedPassword = LoginPassword.getText();

        System.out.println("Login: " + passedLogin + " Password: " + passedPassword);

            Thread th = new Thread(new bg_Thread());
            th.start();
    }
    class bg_Thread implements Runnable{

        @Override
        public void run() {
            myProgressBar.setProgress(0.0);
            for (int i = 0; i <= 4; i++) {
                if (i == 0)
                    myProgressBar.setProgress(0.2);
                if (i == 1)
                    myProgressBar.setProgress(0.6);
                if (i == 2)
                    myProgressBar.setProgress(0.8);
                if (i == 3)
                    myProgressBar.setProgress(1);
                if (i < 4) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (passedLogin.equals("") || passedPassword.equals("")) {
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
}

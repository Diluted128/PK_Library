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
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.example.SendEmail;


public class PasswordReminderController extends Controller {

    @FXML
    private JFXTextArea PasswordReminderEmail;
    @FXML
    private Label MailSentSuccessfully;
    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private JFXButton PasswordReminderButton;
    @FXML
    private JFXButton ReturnButton;

    public void ForgotPasswordSubmit() throws Exception {

        SendEmail.sendMail(PasswordReminderEmail.getText());
        Thread m_th = new Thread(new MailSending_Thread());
        m_th.start();
    }
    public void ForgotPasswordReturn(ActionEvent event) throws Exception {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }

    class  MailSending_Thread implements Runnable {

        @Override
        public  void run() {

            for (int i = 0; i <= 100; i=i+25) {

                myProgressBar.setProgress(i / 100.0);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MailSentSuccessfully.setVisible(true);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MailSentSuccessfully.setVisible(false);
        }
    }
}

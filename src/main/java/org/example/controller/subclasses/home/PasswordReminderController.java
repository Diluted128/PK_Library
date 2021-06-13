package org.example.controller.subclasses.home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.example.SendEmail;
import org.example.controller.abstraction.Controller;
import org.example.db.UserRepository;


public class PasswordReminderController extends Controller {

    @FXML
    private JFXTextArea PasswordReminderEmail;
    @FXML
    private Label MailSentSuccessfully;
    @FXML
    private Label MailNotFound;
    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Label PleaseWaitMessage;

    public void ForgotPasswordSubmit() throws Exception {
        String pom = null;
        pom = UserRepository.getUserRepository().ReturnPasswordIfEmailSuccessful(PasswordReminderEmail.getText());

        Thread m_th = new Thread(new MailSending_Thread(pom));
        m_th.start();
    }
    public void ForgotPasswordReturn(ActionEvent event) throws Exception {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);
    }

    class  MailSending_Thread implements Runnable {

        private String password;

        public MailSending_Thread(String a){
            password = a;
        }
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

            if(password!=null){
                PasswordReminderEmail.getScene().setCursor(Cursor.WAIT);
                PleaseWaitMessage.setVisible(true);
                try {
                    SendEmail.sendMail(PasswordReminderEmail.getText(), password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                PasswordReminderEmail.getScene().setCursor(Cursor.DEFAULT);
                PleaseWaitMessage.setVisible(false);
                MailSentSuccessfully.setVisible(true);
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MailSentSuccessfully.setVisible(false);
            }
            else{
                MailNotFound.setVisible(true);
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MailNotFound.setVisible(false);
            }
        }
    }
}

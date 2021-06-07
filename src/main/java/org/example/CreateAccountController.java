package org.example;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateAccountController {
    @FXML
    private JFXButton CreateAccountButton;
    @FXML
    private Button ReturnButton;
    @FXML
    private JFXTextArea FirstNameTextField;
    @FXML
    private JFXTextArea LastNameTextField;
    @FXML
    private JFXTextArea EmailAddressTextField;
    @FXML
    private JFXTextArea UsernameTextField;
    @FXML
    private JFXTextArea PasswordTextField;
    @FXML
    private CheckBox CheckBox;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label EmptyFields;
    @FXML
    private Label EmptyAgreement;
    @FXML
    private Label SuccesfulLabel;

    private Map<String, String> accountData = new LinkedHashMap<>();


    public void ReturnFunctions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("[1] LoginScene.fxml"));
        Scene LoginReminder = new Scene(root);

        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ourStage.setScene(LoginReminder);
        ourStage.show();

    }

    public void CreateAccountFunctions(ActionEvent event) throws Exception {

        boolean wrongPassword = false;
        boolean emptyFields = false;
        boolean emptyAgree = false;

        accountData.put("FirstName", FirstNameTextField.getText());
        accountData.put("LastName", LastNameTextField.getText());
        accountData.put("EmailAddress", EmailAddressTextField.getText());
        accountData.put("UserName", UsernameTextField.getText());
        accountData.put("Password", PasswordTextField.getText());

        for (Map.Entry<String, String> entry : accountData.entrySet()) {
            if (entry.getValue().equals("")) {
                emptyFields = true;
                break;
            }
        }
        if(!CheckBox.isSelected())
            emptyAgree = true;

        Thread warningThread = new Thread(new warning_Thread(emptyFields,wrongPassword,emptyAgree));
        warningThread.start();
        //Pattern pattern = Pattern.compile(".*[A-Z].*[0-9].*");
        // add pattern for password

    }

    class warning_Thread implements Runnable {

        boolean EmptyField;
        boolean WrongPassword;
        boolean emptyAgreement;

        public warning_Thread(boolean a, boolean b, boolean c){
            EmptyField = a;
            WrongPassword = b;
            emptyAgreement = c;
        }
        public synchronized void run() {
            System.out.println(emptyAgreement);
            progressBar.setProgress(0.0);
            for (int i = 0; i <= 4; i++) {
                if (i == 0)
                    progressBar.setProgress(0.2);
                if (i == 1)
                    progressBar.setProgress(0.6);
                if (i == 2)
                    progressBar.setProgress(0.8);
                if (i == 3)
                    progressBar.setProgress(1);
                if (i < 4) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (EmptyField) {
                EmptyFields.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                EmptyFields.setVisible(false);
            }
            else if(emptyAgreement){
                EmptyAgreement.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                EmptyAgreement.setVisible(false);
            }
            else{
                FirstNameTextField.clear();
                LastNameTextField.clear();
                EmailAddressTextField.clear();
                UsernameTextField.clear();
                PasswordTextField.clear();
                CheckBox.fire();

                SuccesfulLabel.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SuccesfulLabel.setVisible(false);
            }
        }
    }
}


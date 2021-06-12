package org.example.controller.subclasses.home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.controller.abstraction.Controller;
import org.example.db.UserRepository;
import org.example.model.user.Customer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountController extends Controller {
    @FXML
    private JFXButton CreateAccountButton;
    @FXML
    private JFXButton ReturnButton;
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
    @FXML
    private Label UsernameAlreadyTaken;
    @FXML
    private Label wrongPasswordLabel;
    @FXML
    private Label wrongEmailLabel;

    private Map<String, String> accountData = new LinkedHashMap<>();

    private UserRepository userRepository = new UserRepository();


    public void ReturnFunctions(ActionEvent event) throws Exception {
        changeScene(event, "[1] LoginScene.fxml", LoginSceneController.class);

    }

    public void CreateAccountFunctions(ActionEvent event) throws Exception {

        boolean wrongPassword = false;
        boolean emptyFields = false;
        boolean emptyAgree = false;
        boolean wrongEmail = false;
        boolean userAlreadyExists = false;

        Pattern passwordPattern = Pattern.compile("^(?=.*\\d)(?=.*[#$@!%&*.?])[A-Za-z\\d#$@!%&.*?]{8,}$");
        Pattern emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher matcherPassword = passwordPattern.matcher(PasswordTextField.getText());
        Matcher matcherEmail = emailPattern.matcher(EmailAddressTextField.getText());

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

        if(!matcherPassword.matches()){
                wrongPassword = true;
        }

        if(!matcherEmail.matches()) {
                wrongEmail = true;
        }

        if(!wrongPassword && !emptyFields && !wrongEmail && !emptyAgree){
           userAlreadyExists  = userRepository.addNewUserAndReturnIfSuccessful(new Customer(
                            FirstNameTextField.getText(),
                            LastNameTextField.getText(),
                            UsernameTextField.getText(),
                            PasswordTextField.getText(),
                            EmailAddressTextField.getText()
                    ));
           if(userAlreadyExists) {
               FirstNameTextField.clear();
               LastNameTextField.clear();
               EmailAddressTextField.clear();
               UsernameTextField.clear();
               PasswordTextField.clear();
               CheckBox.fire();
           }
        }
            Thread warningThread = new Thread(new warning_Thread(emptyFields, wrongPassword, emptyAgree, wrongEmail,userAlreadyExists));
            warningThread.start();
    }

    class warning_Thread implements Runnable {

        boolean EmptyField;
        boolean WrongPassword;
        boolean emptyAgreement;
        boolean WrongEmail;
        boolean usernameAlreadyTaken;

        public warning_Thread(boolean a, boolean b, boolean c, boolean d, boolean e){
            EmptyField = a;
            WrongPassword = b;
            emptyAgreement = c;
            WrongEmail = d;
            usernameAlreadyTaken = e;
        }

        public synchronized void run() {
            System.out.println(emptyAgreement);
            progressBar.setProgress(0.0);
            for (int i = 0; i <= 100; i++) {
                progressBar.setProgress(0.01 * i);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
            } else if (WrongPassword) {
                wrongPasswordLabel.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wrongPasswordLabel.setVisible(false);
            }
            else if(WrongEmail){
                wrongEmailLabel.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wrongEmailLabel.setVisible(false);
            }
            else if(!usernameAlreadyTaken){
                UsernameAlreadyTaken.setVisible(true);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UsernameAlreadyTaken.setVisible(false);
            }
            else {
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


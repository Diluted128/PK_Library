package org.example.controller.abstraction;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.user.User;

import java.io.IOException;

public abstract class Controller {

    protected User loggedInUser;

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public void changeScene(ActionEvent event, String fxmlFileName, Class<? extends Controller> controllerClass) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/view/" + fxmlFileName));
        Stage ourStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();

        try {
            Controller controller = controllerClass.getConstructor().newInstance();
            controller = fxmlLoader.getController();
            controller.setLoggedInUser(loggedInUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setScene(root,ourStage);
    }




    public void setScene(Parent root, Stage ourStage){
        Scene LoginReminder = new Scene(root);
        ourStage.setScene(LoginReminder);
        ourStage.show();
    }
}

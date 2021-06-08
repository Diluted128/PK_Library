package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.db.UserRepository;
import org.example.library.user.Customer;
import org.example.library.user.Manager;
import org.example.library.user.User;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App extends Application {


        public static void main(String[] args)  {
            addAdminToFileDB();
            launch(args);
        }

        @Override
        public void start(Stage splashScreen) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("[1] LoginScene.fxml"));
          splashScreen.setTitle("Library");
          splashScreen.setResizable(false);
          splashScreen.setScene(new Scene(root));
          splashScreen.show();
        }

        public static void addAdminToFileDB() {
            Manager manager = new Manager(
                    "John",
                    "Doe",
                    "admin",
                    "admin",
                    "admin@gmail.com",
                    new ArrayList<>()
                    );
            new UserRepository().addNewUserAndReturnIfSuccessful(manager);
        }

}
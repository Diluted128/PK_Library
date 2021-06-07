package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;


public class App extends Application {


        public static void main(String[] args)  {
            launch(args);
        }

        @Override
        public void start(Stage splashScreen) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("[1] LoginScene.fxml"));
          splashScreen.setTitle("Library");
          splashScreen.setResizable(false);
          splashScreen.setScene(new Scene(root));
          splashScreen.show();

          System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());


            File file = new File("src/main/resources/org/example/LoginScene.fxml");
            if(file.exists())
            {
                System.out.println("file exist!");//I would print file path here.
            }
            else
            {
                System.out.println("file does not exist!");
            }

    }

}
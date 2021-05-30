package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {


        public static void main(String[] args)  {
            launch(args);
        }

        @Override
        public void start(Stage splashScreen) throws IOException{
          Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
          splashScreen.setTitle("Library");
          splashScreen.setResizable(false);
          splashScreen.setScene(new Scene(root));
          splashScreen.show();

          System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());

            /*
            to confirm that some file exists
            File file = new File("src/main/java/org/example/LoginPage.fxml");
            if(file.exists())
            {
                System.out.println("file exist!");//I would print file path here.
            }
            else
            {
                System.out.println("file does not exist!");
            }
            */
    }

}
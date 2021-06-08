package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.library.item.Book;
import org.example.library.item.Cover;
import org.example.library.item.Genre;
import org.example.library.user.Customer;
import org.example.library.user.Manager;
import org.example.library.user.User;
import org.example.library.user.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class App extends Application {


        public static void main(String[] args)  {
            addInitalData();
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

        public static void addInitalData() {
            Manager manager = new Manager(
                    "John",
                    "Doe",
                    "admin",
                    "admin",
                    "admin@gmail.com",
                    new ArrayList<>()
                    );
            Worker worker = new Worker(
                    "Adam",
                    "Johnson",
                    "worker",
                    "worker",
                    "worker@gmail.com"
            );
            Customer customer = new Customer(
                    "Tom",
                    "Arthur",
                    "customer",
                    "customer",
                    "customer@gmail.com"
            );

            Book book = new Book(
                    List.of("Stephen King"),
                    "Misery",
                    380,
                    "Albatros",
                    Cover.PAPERBACK,
                    Genre.HORROR
            );

            customer.setRentedItems(List.of(book));


            UserRepository userRepository = new UserRepository();
            ItemRepository itemRepository = new ItemRepository();

            userRepository.addNewUserAndReturnIfSuccessful(manager);
            userRepository.addNewUserAndReturnIfSuccessful(worker);
            userRepository.addNewUserAndReturnIfSuccessful(customer);

            itemRepository.addNewItemAndReturnIfSuccessful(book);
        }

}
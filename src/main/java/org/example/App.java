package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.model.item.*;
import org.example.model.user.Customer;
import org.example.model.user.Manager;
import org.example.model.user.Worker;

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
         Parent root = FXMLLoader.load(getClass().getResource("/org/example/view/[1] LoginScene.fxml"));
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
                    "admin@gmail.com"
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
                    "Brown",
                    "customer",
                    "customer",
                    "customer@gmail.com"
            );

            Book bookOne = new Book(
                    List.of("Stephen King"),
                    "Misery",
                    380,
                    "9780450417399",
                    "Albatros",
                    Cover.PAPERBACK,
                    Genre.HORROR
            );
            Book bookTwo = new Book(
                    List.of("Stephen King"),
                    "It",
                    380,
                    "9780452347399",
                    "Albatros",
                    Cover.PAPERBACK,
                    Genre.HORROR
            );
            Book bookThree = new Book(
                    List.of("Stephen King"),
                    "The Stand",
                    380,
                    "9781230417399",
                    "Albatros",
                    Cover.PAPERBACK,
                    Genre.HORROR
            );

            Article article = new Article(
                    List.of("John Doe"),
                    "World",
                    12,
                    "3453464357437",
                    ArticleType.CASE_STUDY
            );

            Newspaper newspaper = new Newspaper(
                    List.of("Matthew Patrick"),
                    "New York Times",
                    25,
                    "3463464573457457",
                    PublishingFrequency.DAY
            );


            List<Item> items = new ArrayList<>(List.of(bookOne, bookTwo, bookThree, article, newspaper));
//            customer.setRentedItems(items);


            UserRepository userRepository = new UserRepository();
            ItemRepository itemRepository = new ItemRepository();

            List<File> files = List.of(
            new File("./src/main/java/org/example/db/users.bin"),
            new File("./src/main/java/org/example/db/items.bin"),
            new File("./src/main/java/org/example/db/actions.bin")
            );
            files.forEach(f -> {
                if (f.exists()) {
                    f.delete();
                }
            });

            userRepository.addNewUserAndReturnIfSuccessful(manager);
            userRepository.addNewUserAndReturnIfSuccessful(worker);
            userRepository.addNewUserAndReturnIfSuccessful(customer);

            itemRepository.addNewItemsAndReturnIfSuccessful(items);




        }

}
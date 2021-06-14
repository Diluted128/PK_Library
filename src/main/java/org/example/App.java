package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.model.action.Action;
import org.example.model.item.*;
import org.example.model.user.Customer;
import org.example.model.user.Manager;
import org.example.model.user.User;
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


            User.setStaticCounterToOne();
            Item.setStaticCounterToOne();
            Action.setStaticCounterToOne();

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
                    "customer@gmail.com",
                    25.50
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
            Book bookFour = new Book(
                    List.of("Walter Isaacson"),
                    "Steve Jobs",
                    735,
                    "9788365312205",
                    "Insignis",
                    Cover.HALF_HARD,
                    Genre.BIOGRAPHY
            );
            Book bookFive = new Book(
                    List.of("Karolina Wasilewska"),
                    "Cyfrodziewczyny, Pionierki Polskiej Informatyki",
                    300,
                    "9788366232877",
                    "Krytyki Politycznej",
                    Cover.HALF_HARD,
                    Genre.HISTORY
            );
            Book bookSix = new Book(
                    List.of("Piotr Kowieski"),
                    "W pogoni za metallica",
                    350,
                    "9788363885359",
                    "ANAKONDA",
                    Cover.HARD,
                    Genre.BIOGRAPHY
            );
            Book bookSeven = new Book(
                    List.of("Andrzej Sapkowski"),
                    "Szpony i Kły",
                    400,
                    "9788375781557",
                    "SUPERNOWA",
                    Cover.HALF_HARD,
                    Genre.FANTASY
            );
            Book bookEight = new Book(
                    List.of("Mariusz Szczygieł"),
                    "Niedziela, ktora zdarzyla się w srodę",
                    171,
                    "9788380494312",
                    "ZARNE",
                    Cover.HARD,
                    Genre.CLASSIC
            );
            Article article = new Article(
                    List.of("John Doe"),
                    "World",
                    12,
                    "3453464357437",
                    ArticleType.CASE_STUDY
            );

            Article articleTwo = new Article(
                    List.of("Carolyn Burdett"),
                    "Aestheticism and decadence",
                    9,
                    "7453466357457",
                    ArticleType.ESSAY
            );
            Article articleThree = new Article(
                    List.of("John Sutherland"),
                    "A reflection on sonnets: ‘When life was sweet beca...",
                    11,
                    "1423466312457",
                    ArticleType.ESSAY
            );

            Article articleFour = new Article(
                    List.of("Mark Lander"),
                    "America May Be ‘Back’ in Europe, but How Much Has Really Changed?",
                    14,
                    "1423466312457",
                    ArticleType.ESSAY
            );
            Newspaper newspaper = new Newspaper(
                    List.of("Matthew Patrick"),
                    "New York Times",
                    25,
                    "3463464573457457",
                    PublishingFrequency.DAY
            );
            Newspaper newspaperTwo = new Newspaper(
                    List.of("Roula Khalaf"),
                    "The Sunday Times",
                    17,
                    "5463464921457457",
                    PublishingFrequency.WEEK
            );
            Newspaper newspaperThree = new Newspaper(
                    List.of("Chris Evans"),
                    "The Daily Telegraph",
                    13,
                    "2363464926757457",
                    PublishingFrequency.DAY
            );
            Newspaper newspaperFour= new Newspaper(
                    List.of("Roula Khalaf"),
                    "Financial Times",
                    14,
                    "2373056126757457",
                    PublishingFrequency.DAY
            );



            List<Item> items = new ArrayList<>(List.of(bookOne, bookTwo, bookThree,bookFour,bookFive, bookSix,bookSeven,bookEight,
                    article,articleTwo, articleThree, articleFour, newspaper, newspaperTwo, newspaperThree, newspaperFour));

            List<User> users = new ArrayList<>(List.of(customer, worker, manager));



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
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            userRepository.saveUsersToFile(users);
            itemRepository.saveItemsToFile(items);
        }
}
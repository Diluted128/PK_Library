package org.example.controller.subclasses.worker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.controller.abstraction.Controller;
import org.example.controller.abstraction.WorkerController;
import org.example.controller.subclasses.customer.MyCustomerProfileController;
import org.example.controller.subclasses.home.LoginSceneController;
import org.example.db.ActionRepository;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.model.action.Action;
import org.example.model.action.Rental;
import org.example.model.action.Reservation;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.item.ItemDTO;
import org.example.model.user.Customer;
import org.example.model.user.Role;
import org.example.model.user.User;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConfirmRentalController extends WorkerController {

    @FXML
    private TextField rentalItemId;
    @FXML
    private TextField idField2;
    @FXML
    private TableView<ItemDTO> items;
    @FXML
    private TableColumn<Item,Integer> ID;
    @FXML
    private TableColumn<Item,String> type;
    @FXML
    private TableColumn<Item,String> title;
    @FXML
    private TableColumn<Item, List<String>> authors;
    @FXML
    private TableColumn<Item, Integer> pages;
    @FXML
    private TableColumn<Item,String> ISBN;
    @FXML
    private TableColumn<Item, Boolean> isReserved;
    @FXML
    private TableColumn<Item, Boolean> isRented;
    @FXML
    private TableColumn<Item, String> publisher;
    @FXML
    private TableColumn<Item, Genre> genre;
    @FXML
    private TableColumn<Item, ArticleType> articleType;

    private int passedRentItemId;



    private UserRepository userRepository = new UserRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private ActionRepository actionRepository = new ActionRepository();


    public void confirmRental(){
        passedRentItemId = Integer.parseInt(rentalItemId.getText());

        List<User> users = userRepository.getAllUsers();
        List<Item> items = itemRepository.getAllItems();
        List<Action> actions = actionRepository.getAllActions();

        Item item = items.stream().filter(i -> i.getItemID() == passedRentItemId).findFirst().get();

        User user = actions.stream()
                .filter(a -> a.getItem().getItemID() == item.getItemID())
                .filter(a -> ((Reservation) a).getPositionInQueue() == 1)
                .map(a -> a.getUser()).findFirst().get();

        actions.stream()
                .filter(a -> a.getItem().equals(item))
                .filter(a -> ((Reservation) a).getPositionInQueue() > 1)
                .forEach(a -> ((Reservation)a).setPositionInQueue(((Reservation) a).getPositionInQueue() - 1));




        item.setIsReserved(false);
        item.setIsRented(true);

        users.stream()
                .filter(u -> u.getLogin().equals(user.getLogin()))
                .forEach(u -> ((Customer)u).removeReservedItem(item));
        users.stream()
                .filter(u -> u.getLogin().equals(user.getLogin()))
                .forEach(u -> ((Customer)u).addRentedItem(item));

//        ((Customer)user).removeReservedItem(item);
//        ((Customer)user).addRentedItem(item);

        actions.add(new Rental(Instant.now(), user, item, 30, true));

        itemRepository.saveItemsToFile(items);
        actionRepository.saveActionsToFile(actions);
        userRepository.saveUsersToFile(users);

        setTableView();


    }
    public void confirmPickup() {

    }

    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        setTableView();
    }


    public void setTableView(){

        ID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
        pages.setCellValueFactory(new PropertyValueFactory<>("numberOfPages"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        isReserved.setCellValueFactory(new PropertyValueFactory<>("isReserved"));
        isRented.setCellValueFactory(new PropertyValueFactory<>("isRented"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        articleType.setCellValueFactory(new PropertyValueFactory<>("articleType"));

        List<Item> customerItems = itemRepository.getAllItems().stream()
                .filter(i -> i.getIsReserved() || i.getIsRented()).collect(Collectors.toList());
        List<ItemDTO> itemsDTO = ItemDTO.getList(customerItems);
        ObservableList<ItemDTO> observableItems = FXCollections.observableArrayList();
        observableItems.addAll(itemsDTO);
        items.setItems(observableItems);


    }

}

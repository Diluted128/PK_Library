package org.example.controller.subclasses.worker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.controller.abstraction.WorkerController;
import org.example.db.ActionRepository;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.exception.IncorrectIdException;
import org.example.exception.RentedBookException;
import org.example.exception.TextFieldEmptyException;
import org.example.model.action.*;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.item.ItemDTO;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class ConfirmRentalController extends WorkerController {

    @FXML
    private TextField rentalItemId;
    @FXML
    private TextField pickupItemId;
    @FXML
    private Label WarningId;
    @FXML
    private Label WarningRented;
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

    boolean rentedWarning = false;
    boolean IDwarning = false;

    private int passedRentItemId;
    private int passedPickupItemId;
    private UserRepository userRepository = new UserRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private ActionRepository actionRepository = new ActionRepository();


    public void confirmRental(){

        try {
            passedRentItemId = Integer.parseInt(rentalItemId.getText());

            try {
                if (rentalItemId.getText().equals("")) {
                    throw new TextFieldEmptyException();
                }
            } catch (TextFieldEmptyException e) {
                System.out.println(e.getMessage());
                IDwarning = true;
                Thread confirm_t = new Thread(new Confirm_Thread(rentedWarning, IDwarning));
                confirm_t.start();
            }

            List<User> users = userRepository.getAllUsers();
            List<Item> items = itemRepository.getAllItems();
            List<Action> actions = actionRepository.getAllActions();

            Item item;
            try {
                item = items.stream().filter(i -> i.getItemID() == passedRentItemId).findFirst().get();
            } catch (Exception e) {
                IDwarning = true;
                throw new IncorrectIdException();
            }


            User user = actions.stream()
                    .filter(a -> a.getItem().getItemID() == item.getItemID())
                    .filter(a -> a.getActionType().equals(ActionType.RESERVATION))
                    .filter(a -> ((Reservation) a).getPositionInQueue() == 1)
                    .map(a -> a.getUser()).findFirst().get();

            actions.stream()
                    .filter(a -> a.getItem().equals(item))
                    .filter(a -> a.getActionType().equals(ActionType.RESERVATION))
                    .filter(a -> ((Reservation) a).getPositionInQueue() > 1)
                    .forEach(a -> ((Reservation) a).setPositionInQueue(((Reservation) a).getPositionInQueue() - 1));


            item.setIsReserved(false);
            item.setIsRented(true);

            users.stream()
                    .filter(u -> u.getLogin().equals(user.getLogin()))
                    .forEach(u -> ((Customer) u).removeReservedItem(item));
            users.stream()
                    .filter(u -> u.getLogin().equals(user.getLogin()))
                    .forEach(u -> ((Customer) u).addRentedItem(item));


            actions.add(new Rental(Instant.now(), user, item, 30, true));

            itemRepository.saveItemsToFile(items);
            actionRepository.saveActionsToFile(actions);
            userRepository.saveUsersToFile(users);

            setTableView();
        }
        catch (Exception e){
            Thread confirm_t = new Thread(new Confirm_Thread(rentedWarning, IDwarning));
            confirm_t.start();
        }
    }



    public void confirmPickup() {

        passedPickupItemId = Integer.parseInt(pickupItemId.getText());

        try {
            if (rentalItemId.getText().equals("")) {
                throw new TextFieldEmptyException();
            }
        } catch (TextFieldEmptyException e) {
            System.out.println(e.getMessage());
            IDwarning = true;
            Thread confirm_t = new Thread(new Confirm_Thread(rentedWarning, IDwarning));
            confirm_t.start();
        }

        List<User> users = userRepository.getAllUsers();
        List<Item> items = itemRepository.getAllItems();
        List<Action> actions = actionRepository.getAllActions();
        Item item;

        try {
            item = items.stream().filter(i -> i.getItemID() == passedPickupItemId).findFirst().get();
        } catch (IncorrectIdException | TextFieldEmptyException | RentedBookException e){
            System.out.println(e.getMessage());
            IDwarning = true;
            Thread confirm_t = new Thread(new Confirm_Thread(rentedWarning, IDwarning));
            confirm_t.start();
            return;
        }

        User user;
        Action action;
        try {
            user = actions.stream()
                    .filter(a -> a.getItem().getItemID() == item.getItemID())
                    .filter(a -> a.getActionType().equals(ActionType.RENTAL))
                    .filter(a -> ((Rental)a).isActive())
                    .map(a -> a.getUser()).findFirst().get();


            action = actions.stream()
                    .filter(a -> a.getItem().getItemID() == item.getItemID())
                    .filter(a -> a.getUser().getUserID() == user.getUserID())
                    .filter(a -> a.getActionType().equals(ActionType.RENTAL))
                    .findFirst().get();
        } catch (IncorrectIdException | TextFieldEmptyException | RentedBookException e){
            System.out.println(e.getMessage());
            rentedWarning = true;
            Thread confirm_t = new Thread(new Confirm_Thread(rentedWarning, IDwarning));
            confirm_t.start();
            return;
        }

        long between = DAYS.between(Instant.now().adjustInto(Instant.now()), Instant.now().adjustInto(action.getTime()));
        int daysDuration = ((Rental) action).getDaysDuration();

        item.setIsReserved(false);
        item.setIsRented(false);

        ((Customer)user).removeRentedItem(item);

        users.stream()
                .filter(u -> u.getLogin().equals(user.getLogin()))
                .forEach(u -> ((Customer) u).removeRentedItem(item));


        double penalty = 0;
        boolean tooLate = false;
        if (between > daysDuration) {
            penalty = between - daysDuration;
            tooLate = true;
            ((Customer) user).setPenalty(((Customer) user).getPenalty() + penalty);
            if (((Customer) user).getPenalty() > 100) {
                ((Customer) user).setOnBlacklist(true);
            }
        }

        actions.add(new Return(Instant.now(), user, item, tooLate, penalty));

        itemRepository.updateItemInfo(item);
        userRepository.updateUserInfo(user);

        itemRepository.saveItemsToFile(items);
        actionRepository.saveActionsToFile(actions);
        userRepository.saveUsersToFile(users);

        setTableView();

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

    class Confirm_Thread implements Runnable {
        boolean rented;
        boolean id;

        public Confirm_Thread(boolean a, boolean b){
            rented = a;
            id = b;
        }

        @Override
        public  void run() {
            if(rented) {
                WarningRented.setVisible(true);
            }
            else {
                WarningId.setVisible(true);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WarningId.setVisible(false);
            WarningRented.setVisible(false);
        }
    }
}

package org.example.customer;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.controller.abstraction.CustomerController;
import org.example.db.ActionRepository;
import org.example.db.ItemRepository;
import org.example.db.UserRepository;
import org.example.exception.IncorrectIdException;
import org.example.exception.TextFieldEmptyException;
import org.example.model.action.Action;
import org.example.model.action.Reservation;
import org.example.model.item.*;
import org.example.model.user.Customer;
import org.example.model.user.Role;
import org.example.model.user.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class RentItemController extends CustomerController {
    @FXML
    private JFXButton rentItemButton;
    @FXML
    private TextField IdField;
    @FXML
    private Label WarningId;
    @FXML
    private ScrollPane scrollPane;
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

    private int passedId;

    private UserRepository userRepository = new UserRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private ActionRepository actionRepository = new ActionRepository();

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

        List<Item> allItems = itemRepository.getAllItems();
        List<ItemDTO> itemsDTO = ItemDTO.getList(allItems);

        ObservableList<ItemDTO> observableItems = FXCollections.observableArrayList();
        observableItems.addAll(itemsDTO);
        items.setItems(observableItems);

    }

    public void reserveItem() {

        try {
            String id = IdField.getText();

            if (id.equals("")) {
                throw new TextFieldEmptyException();
            }
            passedId = Integer.parseInt(id);

            //"Incorrect ID Exception"
            passedId = Integer.parseInt(IdField.getText());

            List<User> users = userRepository.getAllUsers();
            List<Item> items = itemRepository.getAllItems();
            List<Action> actions = actionRepository.getAllActions();

            Optional<Item> optionalItem = items.stream().filter(i -> i.getItemID() == passedId).findFirst();
            User user = users.stream().filter(u -> u.getLogin().equals(loggedInUser.getLogin())).findFirst().get();
            Item item;
            if (optionalItem.isPresent()) {
                item = optionalItem.get();
            } else {
                throw new IncorrectIdException();
            }

            Customer customer = (Customer) user;

            Long positionInQueue = users.stream()
                    .filter(u -> u.getRoles().contains(Role.CUSTOMER))
                    .filter(u -> ((Customer) u).getReservedItems().contains(item))
                    .count();

            item.setIsReserved(true);
            customer.addReservedItem(item);
            actions.add(new Reservation(Instant.now(), user, item, positionInQueue + 1));

            itemRepository.saveItemsToFile(items);
            actionRepository.saveActionsToFile(actions);
            userRepository.saveUsersToFile(users);

            setTableView();
        }
        catch(TextFieldEmptyException | IncorrectIdException e){
            System.out.println(e.getMessage());
            Thread rent_t = new Thread(new Rent_Thread());
            rent_t.start();
        }
    }

    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        setTableView();
    }



    class Rent_Thread implements Runnable {

        @Override
        public  void run() {
            WarningId.setVisible(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WarningId.setVisible(false);
        }
    }
}

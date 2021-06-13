package org.example.controller.subclasses.customer;

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
import org.example.model.action.Action;
import org.example.model.action.Reservation;
import org.example.model.item.*;
import org.example.model.user.Customer;
import org.example.model.user.Role;
import org.example.model.user.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentItemController extends CustomerController {
    @FXML
    private JFXButton rentItemButton;
    @FXML
    private TextField IdField;
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
        //"Incorrect ID"
        passedId = getFromTextField();


        List<User> users = userRepository.getAllUsers();
        List<Item> items = itemRepository.getAllItems();
        List<Action> actions = actionRepository.getAllActions();

        Optional<Item> optionalItem = items.stream().filter(i -> i.getItemID() == passedId).findFirst();
        User user = users.stream().filter(u -> u.getLogin().equals(loggedInUser.getLogin())).findFirst().get();
        Item item;
        if (optionalItem.isPresent()) {
            item = optionalItem.get();
        } else {
            //todo: do what program has to do when bad id is passed
            return;
        }

        Customer customer = (Customer)user;

        Long positionInQueue = users.stream()
                .filter(u -> u.getRoles().contains(Role.CUSTOMER))
                .filter(u -> ((Customer)u).getReservedItems().contains(item))
                .count();

        item.setIsReserved(true);
        customer.addReservedItem(item);
        actions.add(new Reservation(Instant.now(), user, item, positionInQueue + 1));

        itemRepository.saveItemsToFile(items);
        actionRepository.saveActionsToFile(actions);
        userRepository.saveUsersToFile(users);

        setTableView();

    }

    public int getFromTextField() {
        return Integer.parseInt(IdField.getText());
    }

    public void setLoggedInUser(User user) {
        super.setLoggedInUser(user);
        setTableView();
    }
    public TextField getIdField() {
        return IdField;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public JFXButton getRentItemButton() {
        return rentItemButton;
    }

    public void setRentItemButton(JFXButton rentItemButton) {
        this.rentItemButton = rentItemButton;
    }

    public void setIdField(String value) {
        IdField.setText(value);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public TableView<ItemDTO> getItems() {
        return items;
    }

    public void setItems(TableView<ItemDTO> items) {
        this.items = items;
    }

    public TableColumn<Item, Integer> getID() {
        return ID;
    }

    public void setID(TableColumn<Item, Integer> ID) {
        this.ID = ID;
    }

    public TableColumn<Item, String> getType() {
        return type;
    }

    public void setType(TableColumn<Item, String> type) {
        this.type = type;
    }

    public TableColumn<Item, String> getTitle() {
        return title;
    }

    public void setTitle(TableColumn<Item, String> title) {
        this.title = title;
    }

    public TableColumn<Item, List<String>> getAuthors() {
        return authors;
    }

    public void setAuthors(TableColumn<Item, List<String>> authors) {
        this.authors = authors;
    }

    public TableColumn<Item, Integer> getPages() {
        return pages;
    }

    public void setPages(TableColumn<Item, Integer> pages) {
        this.pages = pages;
    }

    public TableColumn<Item, String> getISBN() {
        return ISBN;
    }

    public void setISBN(TableColumn<Item, String> ISBN) {
        this.ISBN = ISBN;
    }

    public TableColumn<Item, Boolean> getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(TableColumn<Item, Boolean> isReserved) {
        this.isReserved = isReserved;
    }

    public TableColumn<Item, Boolean> getIsRented() {
        return isRented;
    }

    public void setIsRented(TableColumn<Item, Boolean> isRented) {
        this.isRented = isRented;
    }

    public TableColumn<Item, String> getPublisher() {
        return publisher;
    }

    public void setPublisher(TableColumn<Item, String> publisher) {
        this.publisher = publisher;
    }

    public TableColumn<Item, Genre> getGenre() {
        return genre;
    }

    public void setGenre(TableColumn<Item, Genre> genre) {
        this.genre = genre;
    }

    public TableColumn<Item, ArticleType> getArticleType() {
        return articleType;
    }

    public void setArticleType(TableColumn<Item, ArticleType> articleType) {
        this.articleType = articleType;
    }

    public int getPassedId() {
        return passedId;
    }

    public void setPassedId(int passedId) {
        this.passedId = passedId;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ActionRepository getActionRepository() {
        return actionRepository;
    }

    public void setActionRepository(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }
}

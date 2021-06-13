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
import org.example.db.ItemRepository;
import org.example.model.item.ArticleType;
import org.example.model.item.Genre;
import org.example.model.item.Item;
import org.example.model.item.ItemDTO;
import org.example.model.user.Customer;
import org.example.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveItemController extends WorkerController {

    @FXML
    private TableView<ItemDTO> items;
    @FXML
    private TableColumn<Item,Integer> Id;
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
    @FXML
    private TextField IdField;

    ItemRepository itemRepository = new ItemRepository();


    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        setTableView();
    }

    public void setTableView(){

        Id.setCellValueFactory(new PropertyValueFactory<>("itemID"));
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
                .filter(i -> !i.getIsRented() && !i.getIsReserved()).collect(Collectors.toList());
        List<ItemDTO> itemsDTO = ItemDTO.getList(customerItems);
        ObservableList<ItemDTO> observableItems = FXCollections.observableArrayList();
        observableItems.addAll(itemsDTO);
        items.setItems(observableItems);

    }

    public void removeItem(){
    //TODO: "Incorrect ID exception"
        List<Item> customerItems = itemRepository.getAllItems();
        customerItems = customerItems.stream()
                .filter(i -> i.getItemID() != Integer.parseInt(IdField.getText()))
                .collect(Collectors.toList());
        itemRepository.saveItemsToFile(customerItems);
        setTableView();
    }


    public String getID() {
        return Id.getText();
    }
}

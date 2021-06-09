module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires com.jfoenix;

    opens org.example to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.controller to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.view to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.model.item to javafx.base;
    // opens org.example.gui to javafx.fxml;
    exports org.example;
    exports org.example.controller;
  //  exports org.example.gui;
}
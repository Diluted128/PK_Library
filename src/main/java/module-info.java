module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires com.jfoenix;
    requires java.logging;

    opens org.example to javafx.fxml, com.jfoenix, javafx.base;

    opens org.example.controller.subclasses.home to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.customer to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.controller.subclasses.worker to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.controller.subclasses.manager to javafx.fxml, com.jfoenix, javafx.base;

    opens org.example.controller.abstraction to javafx.fxml, com.jfoenix, javafx.base;


    opens org.example.view to javafx.fxml, com.jfoenix, javafx.base;
    opens org.example.model.item to javafx.base;

    exports org.example;
    exports org.example.controller;

}
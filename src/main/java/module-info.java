module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires com.jfoenix;

    opens org.example to javafx.fxml;
   // opens org.example.gui to javafx.fxml;
    exports org.example;
  //  exports org.example.gui;
}
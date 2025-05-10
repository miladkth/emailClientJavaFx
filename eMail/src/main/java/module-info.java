module org.example.email {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.activation;
    requires java.mail;


    opens org.example.email to javafx.fxml;
    opens org.example.email.view to javafx.fxml;
    opens org.example.email.controller to javafx.fxml;

    exports org.example.email;

}
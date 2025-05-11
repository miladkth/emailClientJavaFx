package org.example.email;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.email.controller.EmailSender;
import org.example.email.model.EmailAccount;
import org.example.email.view.ViewFactory;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EmailAccount account = new EmailAccount(
                "test@lokalt.se",
                "",
                "localhost",
                1025,
                false
        );

        EmailSender.sendMail(
                account,
                "mottagare@lokalt.se",
                "Test via modell",
                "Det här är ett meddelande via den uppdaterade EmailSender!"
        );
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
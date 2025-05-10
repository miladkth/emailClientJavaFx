package org.example.email;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.email.controller.EmailSender;
import org.example.email.view.ViewFactory;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EmailSender.sendTestMail();
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
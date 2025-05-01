package org.example.email.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.email.EmailManager;
import org.example.email.controller.BaseController;
import org.example.email.controller.LoginWindowController;
import org.example.email.controller.MainWindowController;

import java.io.IOException;

public class ViewFactory {
    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow() {
        System.out.println("Show login window called");

        BaseController baseController = new LoginWindowController(emailManager,this,"LoginWindow.fxml");
        initializeStage(baseController);
    }

    public void showMainWindow() {
        System.out.println("Main window called");

        BaseController baseController = new MainWindowController(emailManager,this,"MainWindow.fxml");
        initializeStage(baseController);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
    }
}

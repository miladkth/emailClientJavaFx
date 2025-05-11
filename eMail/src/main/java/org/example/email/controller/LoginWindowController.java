package org.example.email.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.email.EmailManager;
import org.example.email.controller.service.LoginService;
import org.example.email.model.EmailAccount;
import org.example.email.view.ViewFactory;

public class LoginWindowController extends BaseController {
    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if (fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(),passwordField.getText());
            LoginService loginService = new LoginService(emailAccount,emailManager);
            EmailLoginResult emailLoginResult = loginService.login();

            switch (emailLoginResult) {
                case SUCCESS -> System.out.println("login successfull" + emailAccount);
            }
        }
        System.out.println("loginButtonAction");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
            return false;
        }

        return true;
    }

}

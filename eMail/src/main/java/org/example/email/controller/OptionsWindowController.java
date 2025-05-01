package org.example.email.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import org.example.email.EmailManager;
import org.example.email.view.ViewFactory;

public class OptionsWindowController extends BaseController{

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<?> themePicker;


    @FXML
    void applyBtnAction() {

    }

    @FXML
    void cancelBtnAction() {

    }
}

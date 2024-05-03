package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button login;

    @FXML
    private Button SignUp;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton rememberMe;

    private boolean rememberMeSelected;

    @FXML
    void rememberMeClk(ActionEvent event) {
        rememberMeSelected = rememberMe.isSelected();
    }

    @FXML
    void LoginClk(ActionEvent event) throws IOException {
        // method invocation
        DatabaseConnector.LoginCheck(email.getText(),password.getText());


    }

    @FXML
    void SignUpClk(ActionEvent event) throws IOException {
        HelloApplication.SignUp();
    }

}

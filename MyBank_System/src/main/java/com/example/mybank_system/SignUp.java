package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUp {

    @FXML
    private Button SignUp;

    @FXML
    private TextField username;

    @FXML
    private TextField Nationality;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    void SignUpClk(ActionEvent event) throws IOException {
        // accepting values from text fields
        DatabaseConnector.SignUpDb(username.getText(),Nationality.getText(),email.getText(),password.getText());

        HelloApplication.Login();
    }

}

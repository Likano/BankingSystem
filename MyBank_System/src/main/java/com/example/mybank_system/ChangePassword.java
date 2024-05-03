package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangePassword {

    @FXML
    private TextField Oldemail;

    @FXML
    private PasswordField Oldpassword;

    @FXML
    private PasswordField comfirm;

    @FXML
    private PasswordField Newpassword;

    @FXML
    private Button commit;

    @FXML
    void CommitClk(ActionEvent event) throws IOException {
        DatabaseConnector.ChangePassword(Oldemail.getText(),Oldpassword.getText(),Newpassword.getText());
    }

}

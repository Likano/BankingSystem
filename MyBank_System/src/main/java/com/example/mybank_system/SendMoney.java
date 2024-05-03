package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SendMoney {

    @FXML
    private PasswordField Cpassword;

    @FXML
    private TextField accountNumber;

    @FXML
    private CheckBox Slip;

    @FXML
    private TextField sentAmount;

    @FXML
    private Button login;
    public String Account = "9080008115621";
    @FXML void SlipClk(ActionEvent event) {
        accountNumber.setText(String.valueOf(Account));
        sentAmount.getText();

        if (Slip.isSelected()){
            //Making Alerts
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Account number: "+accountNumber.getText()+"\n Amount Sent M"+sentAmount.getText());
            alert.showAndWait();
    }
    }
    @FXML void SendClk(ActionEvent event) throws IOException {
        accountNumber.setText(String.valueOf(Account));
        sentAmount.getText();

        DatabaseConnector.SentMoney(accountNumber.getText(),sentAmount.getText());
    }



}

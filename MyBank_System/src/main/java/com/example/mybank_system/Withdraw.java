package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Withdraw {

    @FXML private PasswordField password;
    @FXML private TextField Amount;
    @FXML private TextField withdrawal;
    @FXML private TextField Balance;
    @FXML private Button withdraw;
    @FXML private CheckBox Slip;

    double currentAmount = 500.89;
    double balance = 0.00;

    @FXML
    void BalanceFld(ActionEvent event) {
        // setting Balance
        Amount.setText(String.valueOf(currentAmount));
    }

    public double BalanceCal(){
        String Money = withdrawal.getText();

        balance = currentAmount - Integer.parseInt(Money);

        return balance;
    }

    @FXML void WithdrawClk(ActionEvent event) throws IOException {
        Amount.setText(String.valueOf(currentAmount));
        withdrawal.getText();
        Balance.setText(String.valueOf(BalanceCal()));

        DatabaseConnector.WithdrawMoney(Amount.getText(),withdrawal.getText(),Balance.getText());
    }

    @FXML void SlipClk(ActionEvent event) {

        Amount.setText(String.valueOf(currentAmount));
        Balance.setText(String.valueOf(BalanceCal()));
        withdrawal.getText();

        if (Slip.isSelected()){
            //Making Alerts
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Current Amount: M"+Amount.getText()+"\n Amount Withdrawn M"+withdrawal.getText()+"\n Balance: M"+Balance.getText()+"");
            alert.showAndWait();

        }
    }



}

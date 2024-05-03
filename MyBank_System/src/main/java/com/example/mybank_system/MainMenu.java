package com.example.mybank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenu {

    @FXML
    private Button withdraw;

    @FXML
    private Button Sendmoney;

    @FXML
    private Button language;

    @FXML
    private Button Changepin;

    @FXML
    private Button LogOut;

    @FXML
    void ChangepinClk(ActionEvent event) throws IOException {
        HelloApplication.ChangePassword();
    }

    @FXML
    void LanguageClk(ActionEvent event) {
        //Making Alerts
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Current Language is english");
        alert.showAndWait();

    }

    @FXML
    void LogOutClk(ActionEvent event) throws IOException {
        HelloApplication.Login();
    }

    @FXML
    void SendMoneyClk(ActionEvent event) throws IOException {
        HelloApplication.SentMoney();
    }

    @FXML
    void WithdrawClk(ActionEvent event) throws IOException {
        HelloApplication.Withdraw();
    }

}

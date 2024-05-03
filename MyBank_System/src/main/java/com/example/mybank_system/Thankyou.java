package com.example.mybank_system;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Thankyou {

    @FXML
    void LogOutClk(ActionEvent event) throws IOException {
        HelloApplication.Login();
    }

}

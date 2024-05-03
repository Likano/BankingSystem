package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileWriter;
import java.io.IOException;


public class HelloController {
    @FXML private Pane root;
    @FXML private RadioButton dinnerCombo;
    @FXML private RadioButton bbqChicken;
    @FXML private RadioButton beefWellington;
    @FXML private RadioButton cheeseCake;
    @FXML private RadioButton applePie;
    @FXML private RadioButton chocolateChipCookies;
    @FXML private MenuButton chooseDrink;
    @FXML private TextField tip;
    @FXML private TextField amountTendered;
    @FXML private TextField totalAmount;
    @FXML private Button change;
    @FXML private Button reset;
    @FXML private Button exit;

    private double computeTotalAmount() {
        double total = 0.0;
        if (dinnerCombo.isSelected()) {
            total += 120.00;
        } else if (bbqChicken.isSelected()) {
            total += 180.00;
        } else if (beefWellington.isSelected()) {
            total += 200.00;
        }

        if (cheeseCake.isSelected()) {
            total += 60.00;
        } else if (applePie.isSelected()) {
            total += 50.00;
        } else if (chocolateChipCookies.isSelected()) {
            total += 40.00;
        }

        if (chooseDrink.getItems().size() > 0) {
            MenuItem selectedDrink = chooseDrink.getItems().get(0);
            total += Double.parseDouble(selectedDrink.getId());
        }

        return total;
    }

    private double computeChange() {
        double total = Double.parseDouble(totalAmount.getText());
        double tipAmount = Double.parseDouble(tip.getText());
        double tendered = Double.parseDouble(amountTendered.getText());
        return tendered - (total + tipAmount);
    }

    @FXML
    private void handleTotalAmount() {
        double total = computeTotalAmount();
        double tipAmount = Double.parseDouble(tip.getText());
        totalAmount.setText(String.format("%.2f", total + tipAmount));
    }

    @FXML
    private void handleChange() {
        double changeAmount = computeChange();
        totalAmount.setText("");
        tip.setText("");
        amountTendered.setText(String.format("%.2f", changeAmount));
    }

    @FXML
    private void handleReset() {
        dinnerCombo.setSelected(false);
        bbqChicken.setSelected(false);
        beefWellington.setSelected(false);
        cheeseCake.setSelected(false);
        applePie.setSelected(false);
        chocolateChipCookies.setSelected(false);
        chooseDrink.getItems().clear();
        tip.setText("");
        amountTendered.setText("");
        totalAmount.setText("");
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}

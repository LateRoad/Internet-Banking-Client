package com.lateroad.bank.controller;

import com.lateroad.bank.logic.connection.ServerConnection;
import com.lateroad.bank.model.CurrentUserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PaymentController {

    @FXML public Label label;
    @FXML public TextField mobileNumber;
    @FXML public TextField money;

    private String currentPayment = "MTC";

    @FXML
    public void mtcNumberPayment(ActionEvent actionEvent) {
        label.setText("МТС (по номеру)");
        currentPayment = "MTC";
    }

    @FXML
    public void velcomNumberPayment(ActionEvent actionEvent) {
        label.setText("VELCOM (по номеру)");
        currentPayment = "VELCOM";
    }

    @FXML
    public void lifeNumberPayment(ActionEvent actionEvent) {
        label.setText("Life :) (по номеру)");
        currentPayment = "LIFE";
    }

    @FXML
    public void mtcBillPayment(ActionEvent actionEvent) {
        label.setText("МТС (по лицевому счёту)");
        currentPayment = "MTC";
    }

    @FXML
    public void velcomBillPayment(ActionEvent actionEvent) {
        label.setText("VELCOM (по лицевому счёту)");
        currentPayment = "VELCOM";
    }

    @FXML
    public void payment(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        try {
            connection.sendMessage("PAYMENT%21" + mobileNumber.getText() + "%20" + currentPayment + "%20" + money.getText() + "%20" + CurrentUserModel.getInstance().getCurrentCard().getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

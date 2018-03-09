package com.lateroad.bank.controller;

import com.lateroad.bank.logic.connection.ServerConnection;
import com.lateroad.bank.model.CurrentUserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TransferController {
    @FXML
    public TextField receiver;
    @FXML
    public TextField money;

    @FXML
    public void transfer(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        try {
            connection.sendMessage("TRANSFER%21" + receiver.getText() + "%20" + money.getText() + "%20" + CurrentUserModel.getInstance().getCurrentCard().getNumber());
        } catch (Exception e) {
        }
    }
}


package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.connection.ServerConnection;
import model.CurrentUserModel;

public class TransferController {
    @FXML public TextField receiver;
    @FXML public TextField transferSum;

    @FXML
    public void transfer(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        try {
            connection.sendMessage("TRANSFER%21" + receiver.getText() + "%20" + transferSum.getText() + "%20" + CurrentUserModel.getInstance().getCurrentCard().getNumber());
        } catch (Exception e) {
        }
    }
}


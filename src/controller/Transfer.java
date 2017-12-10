package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import logic.connection.ServerConnection;
import model.CurrentUserModel;

public class Transfer {
    public TextField receiver;
    public TextField transferSum;

    public void transfer(ActionEvent actionEvent) {
        ServerConnection connection = ServerConnection.getInstance();
        try {
            connection.sendMessage("TRANSFER%21" + receiver.getText() + "%20" + transferSum.getText() + "%20" + CurrentUserModel.getInstance().getCurrentCard().getNumber());
        } catch (Exception e) {
        }
    }
}


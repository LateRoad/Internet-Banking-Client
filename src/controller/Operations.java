package controller;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Operations implements Initializable{
    public JFXDrawer operationDrawer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/content/operations/transfer.fxml"));
            operationDrawer.setSidePane(anchorPane);
            operationDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPayment(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/content/operations/payment.fxml"));
            operationDrawer.setSidePane(anchorPane);
            operationDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTransfer(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/content/operations/transfer.fxml"));
            operationDrawer.setSidePane(anchorPane);
            operationDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

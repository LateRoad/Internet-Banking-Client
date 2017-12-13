package controller;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OperationsController implements Initializable {
    @FXML
    public JFXDrawer operationDrawer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showContent("/view/content/operations/transfer.fxml");
    }

    public void showPayment(ActionEvent actionEvent) {
        showContent("/view/content/operations/payment.fxml");
    }

    public void showTransfer(ActionEvent actionEvent) {
        showContent("/view/content/operations/transfer.fxml");
    }

    private void showContent(String path) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));
            operationDrawer.setSidePane(anchorPane);
            operationDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

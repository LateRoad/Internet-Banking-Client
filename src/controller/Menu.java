package controller;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    @FXML public BorderPane borderPane;
    @FXML public JFXDrawer contentDrawer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            VBox vBox = FXMLLoader.load(getClass().getResource("/view/content/home.fxml"));
            contentDrawer.setSidePane(vBox);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHome(ActionEvent actionEvent) {
        try {
            VBox vBox = FXMLLoader.load(getClass().getResource("/view/content/home.fxml"));
            contentDrawer.setSidePane(vBox);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCards(ActionEvent actionEvent) {
        try {
            AnchorPane vBox = FXMLLoader.load(getClass().getResource("/view/content/cards.fxml"));
            contentDrawer.setSidePane(vBox);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showActions(ActionEvent actionEvent) {
        try {
            AnchorPane vBox = FXMLLoader.load(getClass().getResource("/view/content/operations.fxml"));
            contentDrawer.setSidePane(vBox);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAboutUs(ActionEvent actionEvent) {
        try {
            AnchorPane vBox = FXMLLoader.load(getClass().getResource("/view/content/aboutUs.fxml"));
            contentDrawer.setSidePane(vBox);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

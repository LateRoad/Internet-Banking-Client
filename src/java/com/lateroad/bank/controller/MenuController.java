package com.lateroad.bank.controller;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    public BorderPane borderPane;
    @FXML
    public JFXDrawer contentDrawer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showContent("/view/content/home.fxml");
    }

    public void showHome(ActionEvent actionEvent) {
        showContent("/view/content/home.fxml");
    }

    public void showCards(ActionEvent actionEvent) {
        showContent("/view/content/cards.fxml");
    }

    public void showActions(ActionEvent actionEvent) {
        showContent("/view/content/operations.fxml");
    }

    public void showAboutUs(ActionEvent actionEvent) {
        showContent("/view/content/aboutUs.fxml");
    }

    private void showContent(String path) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));
            contentDrawer.setSidePane(anchorPane);
            contentDrawer.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

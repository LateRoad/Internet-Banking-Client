package com.lateroad.bank.controller;

import com.lateroad.bank.logic.entity.Card;
import com.lateroad.bank.model.CurrentUserModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CardsController implements Initializable {
    @FXML public TableView<Card> tableViewCard;
    @FXML public TableColumn<Card, String> numberColumn;
    @FXML public TableColumn<Card, String> endDateColumn;
    @FXML public TableColumn<Card, String> moneyColumn;

    private CurrentUserModel model = CurrentUserModel.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<>("money"));
        for (int i = 0; i < model.getCards().size(); ++i) {
            tableViewCard.getItems().add(model.getCards().get(i));
        }
    }
}



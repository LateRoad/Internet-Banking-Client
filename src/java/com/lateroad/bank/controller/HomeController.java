package com.lateroad.bank.controller;

import com.jfoenix.controls.JFXComboBox;
import com.lateroad.bank.logic.entity.Card;
import com.lateroad.bank.model.CurrentUserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML public Text allMoney;
    @FXML public Text currentCardMoney;
    @FXML public JFXComboBox currentCard;

    private static final String CARD_NUMBER_MASK = "**** ";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CurrentUserModel model = CurrentUserModel.getInstance();
        BigDecimal moneySum = new BigDecimal("0");
        for (Card card : model.getCards()) {
            BigDecimal cardMoney = new BigDecimal(card.getMoney());
            moneySum = moneySum.add(cardMoney);
            currentCard.getItems().add(CARD_NUMBER_MASK + card.getNumber().split(" ")[3]);
            currentCard.getSelectionModel().select(CARD_NUMBER_MASK + card.getNumber().split(" ")[3]);
            setCurrentCard(CARD_NUMBER_MASK + card.getNumber().split(" ")[3]);
        }
        allMoney.setText("$ " + moneySum.toString());
    }

    public void changeCard(ActionEvent actionEvent) {
        setCurrentCard((String) currentCard.getSelectionModel().getSelectedItem());
    }

    private void setCurrentCard(String currentCard) {
        String cardNumber = currentCard.split(" ")[1];
        for (Card card : CurrentUserModel.getInstance().getCards()) {
            if (card.getNumber().contains(cardNumber)) {
                currentCardMoney.setText("$ " + card.getMoney());
                CurrentUserModel.getInstance().setCurrentCard(card);
            }
        }

    }
}

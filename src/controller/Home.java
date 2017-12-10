package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import logic.entity.Card;
import model.CurrentUserModel;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    public Text allMoney;
    public Text currentCardMoney;
    public JFXComboBox currentCard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CurrentUserModel model = CurrentUserModel.getInstance();
        BigDecimal moneySum = new BigDecimal("0");
        for (Card card : model.getCards()) {
            BigDecimal cardMoney = new BigDecimal(card.getMoney());
            moneySum = moneySum.add(cardMoney);
            currentCard.getItems().add("**** " + card.getNumber().split(" ")[3]);
            currentCard.getSelectionModel().select("**** " + card.getNumber().split(" ")[3]);
            setCurrentCard("**** " + card.getNumber().split(" ")[3]);
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

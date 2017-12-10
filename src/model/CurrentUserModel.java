package model;

import logic.entity.Card;
import logic.entity.User;

import java.util.ArrayList;

public class CurrentUserModel {
    private User currentUser;
    private Card currentCard;
    private ArrayList<Card> cards;
    private static final CurrentUserModel instance = new CurrentUserModel();

    private CurrentUserModel() {
        cards = new ArrayList<>();
    }

    public static CurrentUserModel getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void setCard(int i, Card card) {
        this.cards = cards;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
}

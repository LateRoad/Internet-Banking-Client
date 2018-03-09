package com.lateroad.bank.model;

import com.lateroad.bank.logic.entity.Card;
import com.lateroad.bank.logic.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CurrentUserModel {
    private User currentUser;
    private Card currentCard;
    private List<Card> cards;
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void setCard(int index, Card card) {
        this.cards.set(index, card);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
}

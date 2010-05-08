package com.goldenweek.cards.model;

public class Discard extends Deck {
    public Card discard(Card c) {
        return this.add(c);
    }
}

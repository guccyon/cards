package com.goldenweek.cards.model;

public enum Suit {
    SPADE(4),
    HEART(3),
    DIAMOND(2),
    CLUBS(1),;
    
    private int suit;

    private Suit(final int suit) {
        this.suit = suit;
    }

    public boolean isStrong(Suit obj) {
        return this.suit > obj.suit;
    }

    public boolean isWeak(Suit obj) {
        return this.suit < obj.suit;
    }

    public boolean isEqual(Suit obj) {
        return this == obj;
    }
}

package com.goldenweek.cards.model;

import java.util.Collection;
import java.util.Random;

public class Pool extends Deck {

    public Pool() {
        super();
    }

    public Pool(Collection<Card> c) {
        super(c);
    }

    public boolean hasCard(Card c) {
        throw new UnsupportedOperationException("\"hasCard\" is not permitted on Pool");
    }

    public Card draw() {
        return this.remove(this.getAt(new Random().nextInt(this.size())));
    }

    public Card draw(Card c) {
        return this.remove(c);
    }
}

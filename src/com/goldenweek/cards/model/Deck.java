package com.goldenweek.cards.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Deck {

    private List<Card> cards;

    public Deck(Collection<Card> c) {
        this.cards = new ArrayList<Card>(c);
    }
    
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public int size() {
        return this.cards.size();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public boolean hasCard(Card that) {
        return getIndex(that) >= 0 ? true : false;
    }

    public String toJson() {
        StringBuffer jsonBuf = new StringBuffer("{cards:[");
        for (Iterator<Card> it = this.cards.iterator(); it.hasNext();) {
            Card c = it.next();
            jsonBuf.append(c.toJson());
            if (it.hasNext()) {
                jsonBuf.append(",");
            }
        }
        jsonBuf.append("]}");
        return jsonBuf.toString();
    }

    public Iterator<Card> iterator() {
        return Collections.unmodifiableList(this.cards).iterator();
    }

    public Card add(Card c) {
        this.cards.add(c);
        return c;
    }

    public Card remove(Card c) throws NoSuchElementException {
        int i = this.getIndex(c);
        if (i < 0) {
            throw new NoSuchElementException("Could not find the card " + c.toJson());
        }
        this.cards.remove(i);
        return c;
    }

    protected int getIndex(Card c) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i).equals(c)) {
                return i;
            }
        }
        return -1;
    }

    protected Card getAt(int index) {
        return this.cards.get(index);
    }
}

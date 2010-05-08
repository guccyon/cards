package com.goldenweek.cards.model;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class PoolTest {
    @Test
    public void testHasCard() {
        try {
            Pool p = new Pool();
            p.hasCard(Card.createCard(Suit.HEART, 2));
            fail();
        } catch (UnsupportedOperationException e) {
            // expected work
        }
    }

    @Test
    public void testDrawRandom() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Pool p = new Pool(cs);
        Deck expected = new Deck(cs);

        assertTrue(expected.hasCard(p.draw()));
        assertTrue(expected.hasCard(p.draw()));

        assertTrue(p.isEmpty());
    }

    @Test
    public void testDrawSpecific() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Pool p = new Pool(cs);

        assertEquals(Card.createCard(Suit.CLUBS, 2), p.draw(Card.createCard(Suit.CLUBS, 2)));
        assertEquals(1, p.size());
    }
}
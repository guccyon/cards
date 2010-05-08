package com.goldenweek.cards.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {
    @Test
    public void testDefaultContructor() {
        Deck d = new Deck();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
        assertFalse(d.iterator().hasNext());
    }

    @Test
    public void testContructorFromCollection() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Deck d = new Deck(cs);

        List<Card> actual = new ArrayList<Card>();
        for (Iterator<Card> it = d.iterator(); it.hasNext();) {
            actual.add(it.next());
        }
        assertArrayEquals("", cs.toArray(new Card[2]), actual.toArray(new Card[2]));
        assertEquals(2, d.size());
        assertFalse(d.isEmpty());
    }

    @Test
    public void testHasCard() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Deck d = new Deck(cs);

        assertTrue(d.hasCard(Card.createCard(Suit.CLUBS, 2)));
        assertTrue(d.hasCard(Card.createCard(Suit.HEART, 1)));
        assertFalse(d.hasCard(Card.createCard(Suit.CLUBS, 13)));
    }

    @Test
    public void testToJson() {
        String expected = "{cards:["
            + Card.createCard(Suit.HEART, 1).toJson()
            + "," + Card.createCard(Suit.CLUBS, 2).toJson()
            + "]}";

        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Deck d = new Deck(cs);
        assertEquals(expected, d.toJson());
    }

    @Test
    public void testAdd() {
        Deck d = new Deck();
        
        d.add(Card.createCard(Suit.SPADE, 5));

        assertEquals(1, d.size());
        assertFalse(d.isEmpty());
        assertTrue(d.hasCard(Card.createCard(Suit.SPADE, 5)));
    }

    @Test
    public void testRemove() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Deck d = new Deck(cs);

        d.remove(Card.createCard(Suit.CLUBS, 2));

        assertFalse(d.hasCard(Card.createCard(Suit.CLUBS, 2)));
    }

    @Test
    public void testRemoveException() {
        Deck d = new Deck();
        try {
            d.remove(Card.createCard(Suit.DIAMOND, 3));
            fail("Exception was not thrown");
        } catch (NoSuchElementException e) {
            // expected work
        }
    }

    @Test
    public void testGetAt() {
        List<Card> cs = new ArrayList<Card>();
        cs.add(Card.createCard(Suit.HEART, 1));
        cs.add(Card.createCard(Suit.CLUBS, 2));
        Deck d = new Deck(cs);

        assertEquals(Card.createCard(Suit.CLUBS, 2), d.getAt(1));
    }
}

package com.goldenweek.cards.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiscardTest {
    @Test
    public void testDiscard() {
        Discard di = new Discard();
        di.discard(Card.createCard(Suit.HEART, 5));
        assertTrue(di.hasCard(Card.createCard(Suit.HEART, 5)));
    }
}

package com.goldenweek.cards.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class HandTest {
    @Test
    public void testSame() {
        Deck hand = new Hand();
        assertTrue(hand.isEmpty());
    }
}

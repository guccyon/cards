package com.goldenweek.cards.model;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.goldenweek.cards.model.Card;
import com.goldenweek.cards.model.Suit;


public class CardTest {

	@Test
	public void equalSuitTest() {
		Card card = Card.createCard(Suit.CLUBS, 1);
		assertTrue(card.equalSuit(Suit.CLUBS));
		
		Card card2 = Card.createCard(Suit.DIAMOND, 1);
		assertTrue(card2.equalSuit(Suit.DIAMOND));
		
		Card card3 = Card.createCard(Suit.HEART, 1);
		assertTrue(card3.equalSuit(Suit.HEART));
		
		Card card4 = Card.createCard(Suit.SPADE, 1);
		assertTrue(card4.equalSuit(Suit.SPADE));
	}
	
	@Test
	public void equalNumberTest() {
		Card card = Card.createCard(Suit.SPADE, 1);
		assertTrue(card.equalNumber(1));
		
		Card card2 = Card.createCard(Suit.SPADE, 13);
		assertTrue(card2.equalNumber(13));
	}
	
	@Test
	public void lessThanTest() {
		Card card = Card.createCard(Suit.CLUBS, 1);
		assertTrue(card.lessThan(Card.createCard(Suit.CLUBS, 2)));
		assertTrue(card.lessThan(Card.createCard(Suit.HEART, 1)));
	}
	
	@Test
	public void greaterThanTest() {
		Card card = Card.createCard(Suit.SPADE, 13);
		assertTrue(card.greaterThan(Card.createCard(Suit.CLUBS, 2)));
		assertTrue(card.greaterThan(Card.createCard(Suit.HEART, 13)));
	}
	
	@Test
	public void createCardOverTest() {
		try {
			Card.createCard(Suit.CLUBS, 14);
			fail();
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	public void createCardUnderTest() {
		try {
			Card.createCard(Suit.CLUBS, 0);
			fail();
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	public void equalsTest() {
		Card card = Card.createCard(Suit.CLUBS, 5);
		assertTrue(card.equals(Card.createCard(Suit.CLUBS, 5)));
	}
	
}

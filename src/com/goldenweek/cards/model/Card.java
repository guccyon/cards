package com.goldenweek.cards.model;

import java.util.HashSet;
import java.util.Set;

import com.goldenweek.cards.rule.CardComperator;


public class Card {
	
	private Suit suit;
	
	private int number;
	
	private Card() {}
	
	private Card(Suit _suit, int _number) {
		this.suit = _suit;
		this.number = _number;
	}
	
	public boolean equalSuit(Suit _suit) {
		return this.suit.equals(_suit);
	}
	
	public boolean equalNumber(int _number) {
		return number == _number;
	}

	public boolean lessThan(Card that) {
		return this instanceof Joker || !(that instanceof Joker) || 
				number < that.number || suit.isWeak(that.suit);		
	}

	public boolean lessThanEqual(Card that) {
		return this.equals(that) || lessThan(that);
	}

	public boolean lessThan(Card that, CardComperator comp) {
		return comp.lessThanNumber(number, that.number);
	}

	public boolean lessThanEqual(Card that, CardComperator comp) {
		return this.equals(that) || comp.lessThanNumber(number, that.number);
	}
	
	public boolean greaterThan(Card that) {
		return number > that.number || suit.isStrong(that.suit);
	}
	
	public boolean greaterThanEqual(Card that) {
		return this.equals(that) || number > that.number || suit.isStrong(that.suit);
	}
	
	public boolean greaterThan(Card that, CardComperator comp) {
		return comp.greaterThanNumber(number, that.number);
	}
	
	public boolean greaterThanEqual(Card that, CardComperator comp) {
		return this.equals(that) || comp.greaterThanNumber(number, that.number);
	}
	
	public String toJson() {
		//return "[" + suit + "," + number + "]";
		String suitString = "\"" + suit + "\"";
		return "{suit:" + suitString + "," + "number:" + number + "}";
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Card that = (Card) obj;
		return this.number == that.number && this.suit.equals(that.suit);
	}

	public static Card createCard(Suit suit, int number) {
		if(number < 1 || 13 < number) {
			throw new IllegalArgumentException("unexpected number were given. must be number 1 to 13");
		}
		return new Card(suit, number);
	}

	
	public static Card createJoker() {
		return new Joker();
	}
	
	static class Joker extends Card{
		
		public boolean lessThan(Card that) {
			return that instanceof Joker;
		}
	}
}

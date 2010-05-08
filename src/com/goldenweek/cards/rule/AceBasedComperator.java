package com.goldenweek.cards.rule;


public class AceBasedComperator implements CardComperator {

	@Override
	public boolean greaterThanNumber(int a, int b) {
		return a == 1 && b != 1 ||
			   a > b  && b != 1;
	}

	@Override
	public boolean lessThanNumber(int a, int b) {
		return b == 1 && a != 1 ||
			   a < b  && a != 1;
	}
}

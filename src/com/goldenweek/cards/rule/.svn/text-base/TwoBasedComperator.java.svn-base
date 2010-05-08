package com.goldenweek.cards.rule;

public class TwoBasedComperator implements CardComperator {

	@Override
	public boolean greaterThanNumber(int a, int b) {
		return a == 2 && b != 2 ||
			   a == 1 && b != 2 && b != 1 ||
			   a > b  && b != 2 && b != 1;
	}

	@Override
	public boolean lessThanNumber(int a, int b) {
		return b == 2 && a != 2 ||
			   b == 1 && a != 2 && a != 1 ||
			   a < b  && a != 2 && a != 1;
	}

}

package com.goldenweek.cards.model;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	CardTest.class,
	ContextTest.class,
	DeckTest.class,
	DiscardTest.class,
	HandTest.class,
	PoolTest.class,
	SuitTest.class
})
public class TestSuite {

	public static void main(final String[] args) {
		JUnitCore.main(TestSuite.class.getName());
	}
}

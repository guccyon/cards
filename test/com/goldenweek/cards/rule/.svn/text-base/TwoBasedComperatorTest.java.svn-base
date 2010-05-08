package com.goldenweek.cards.rule;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TwoBasedComperatorTest {

	
	@Test
	public void greaterThanNumberTest() {
		TwoBasedComperator comp = new TwoBasedComperator();
		assertTrue(comp.greaterThanNumber(2, 1));
		assertTrue(comp.greaterThanNumber(2, 13));
		assertTrue(comp.greaterThanNumber(2, 3));
		assertTrue(comp.greaterThanNumber(1, 13));
		assertTrue(comp.greaterThanNumber(1, 3));
		assertTrue(comp.greaterThanNumber(13, 12));
		assertTrue(comp.greaterThanNumber(13, 3));
		
		assertFalse(comp.greaterThanNumber(1, 2));
		assertFalse(comp.greaterThanNumber(13, 2));
		assertFalse(comp.greaterThanNumber(3, 2));
		assertFalse(comp.greaterThanNumber(13, 1));
		assertFalse(comp.greaterThanNumber(3, 1));
		assertFalse(comp.greaterThanNumber(12, 13));
		assertFalse(comp.greaterThanNumber(3, 13));
	}

	
	@Test
	public void lessThanNumberTest() {
		TwoBasedComperator comp = new TwoBasedComperator();
		assertTrue(comp.lessThanNumber(1, 2));
		assertTrue(comp.lessThanNumber(13, 2));
		assertTrue(comp.lessThanNumber(3, 2));
		assertTrue(comp.lessThanNumber(13, 1));
		assertTrue(comp.lessThanNumber(3, 1));
		assertTrue(comp.lessThanNumber(12, 13));
		assertTrue(comp.lessThanNumber(3, 13));
		
		assertFalse(comp.lessThanNumber(2, 1));
		assertFalse(comp.lessThanNumber(2, 13));
		assertFalse(comp.lessThanNumber(2, 3));
		assertFalse(comp.lessThanNumber(1, 13));
		assertFalse(comp.lessThanNumber(1, 3));
		assertFalse(comp.lessThanNumber(13, 12));
		assertFalse(comp.lessThanNumber(13, 3));
	}
}

package com.goldenweek.cards.rule;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class AceBasedComperatorTest {
	
	@Test
	public void greaterThanNumberTest() {
		AceBasedComperator comp = new AceBasedComperator();
		assertTrue(comp.greaterThanNumber(1, 2));
		assertTrue(comp.greaterThanNumber(1, 13));
		assertTrue(comp.greaterThanNumber(13, 2));
		assertTrue(comp.greaterThanNumber(13, 12));
		
		assertFalse(comp.greaterThanNumber(13, 1));
		assertFalse(comp.greaterThanNumber(2, 1));
		assertFalse(comp.greaterThanNumber(12, 13));
		assertFalse(comp.greaterThanNumber(2, 13));
	}

	
	@Test
	public void lessThanNumberTest() {
		AceBasedComperator comp = new AceBasedComperator();
		assertTrue(comp.lessThanNumber(13, 1));
		assertTrue(comp.lessThanNumber(2, 1));
		assertTrue(comp.lessThanNumber(12, 13));
		assertTrue(comp.lessThanNumber(2, 13));
		
		assertFalse(comp.lessThanNumber(1, 2));
		assertFalse(comp.lessThanNumber(1, 13));
		assertFalse(comp.lessThanNumber(13, 2));
		assertFalse(comp.lessThanNumber(13, 12));
	}
}

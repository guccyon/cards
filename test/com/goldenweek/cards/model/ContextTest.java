package com.goldenweek.cards.model;


import static org.junit.Assert.*;

import org.junit.Test;

import com.goldenweek.cards.exception.NoKeyException;


public class ContextTest {

	@Test
	public void getIdTest() {
		try {
			new Context().getId();
			fail();
		} catch(NoKeyException e) {
			assertEquals("1度も保存されていないのでIDが割り当てられていません。", e.getMessage());
		}
	}
}

package com.goldenweek.cards.controller;

import javax.servlet.http.HttpServletRequest;

import com.goldenweek.cards.model.Card;
import com.goldenweek.cards.model.Context;
import com.goldenweek.cards.model.Hand;

public class PoolController {

	public String delegate(HttpServletRequest req, String actionPath) {

		if (req.getMethod().toLowerCase().equals("get")) {
			return draw(req);
		}
		
		throw new UnsupportedOperationException();
	}
	
	public String draw(HttpServletRequest req) {
		String cotextId = req.getParameter("contextId");
		String playerId = req.getParameter("palyerId");
		
		Context context = new Context();
		Hand hand = new Hand();
		Card card = context.poolToHand(hand);
		return card.toJson();
	}
	
	public String count(HttpServletRequest req) {
		String cotextId = req.getParameter("contextId");
		String playerId = req.getParameter("palyerId");
		
		Context context = new Context();
		return "{count: " + context.getPool().size() + "}";
	}
}

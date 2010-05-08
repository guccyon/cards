package com.goldenweek.cards.controller;

import javax.servlet.http.HttpServletRequest;

import com.goldenweek.cards.model.Card;
import com.goldenweek.cards.model.Context;
import com.goldenweek.cards.model.Hand;
import com.goldenweek.cards.model.Suit;

public class DiscardController {
	
	public String delegate(HttpServletRequest req, String actionPath) {
		if(req.getMethod().toLowerCase().equals("post") || req.getMethod().toLowerCase().equals("get")) {
			return discard(req);
		}
		
		throw new UnsupportedOperationException();
	}

	public String discard(HttpServletRequest req) {
		String cotextId = req.getParameter("contextId");
		String playerId = req.getParameter("palyerId");
		
		Context context = new Context();
		
		Hand hand = new Hand();
		
		Card card = context.handToDiscard(hand, 
				Card.createCard(Suit.valueOf(req.getParameter("suit")), 
								Integer.parseInt(req.getParameter("number"))));
		return card.toJson();
	}
}

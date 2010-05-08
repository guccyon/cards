package com.goldenweek.cards.controller;

import javax.servlet.http.HttpServletRequest;


public class CardsController {
	
	public String delegate(HttpServletRequest req, String actionPath) {

		if (req.getMethod().toLowerCase().equals("get")) {
			return new PoolController().draw(req);
		} else if(req.getMethod().toLowerCase().equals("post")){
			return new DiscardController().discard(req);
		}

		throw new UnsupportedOperationException();
	}
}

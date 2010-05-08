package com.goldenweek.cards.controller;

import javax.servlet.http.HttpServletRequest;

import com.goldenweek.cards.model.Context;

public class ContextController {
	
	public String delegate(HttpServletRequest req, String actionPath) {
		if(req.getMethod().toLowerCase().equals("post") || req.getMethod().toLowerCase().equals("get")) {
			return create(req);
		} else if(req.getMethod().toLowerCase().equals("delete")) {
			return finish(req);
		} else {
			return "get";
		}
	}
	
	public String create(HttpServletRequest req) {
		Context context = new Context();
		context.initialize();
		System.out.println("context create");
		//context.insertOrUpdate();
		System.out.println("context save");
		//String id = "\"" + context.getId() + "hogehoge\"";
		String id = "\"" + "hogehoge\"";
		
		return "{contextId:" + id + ", playerId: 11111}";
	}
	
	public String finish(HttpServletRequest req) {
		return "finish";
	}
}

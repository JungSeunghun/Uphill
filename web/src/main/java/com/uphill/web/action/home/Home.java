package com.uphill.web.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();		
		session.removeAttribute("loginFail");
		
		return new ViewResolver("/views/home/home.tiles");
	}
	
}

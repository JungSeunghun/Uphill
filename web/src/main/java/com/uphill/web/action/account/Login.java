package com.uphill.web.action.account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class Login implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++){
			String cookieName = cookies[i].getName();
			
			if(cookieName.equals("userIdCookie")){
				request.setAttribute("userIdCookie", cookies[i].getValue());
			}
			
			if(cookieName.equals("rememberIdCookie")){
				request.setAttribute("rememberIdCookie", cookies[i].getValue());
			}
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userVO") != null) {
			return new ViewResolver("/home/home", true);			
		}
		
		return new ViewResolver("/views/account/login.tiles");
	}

}

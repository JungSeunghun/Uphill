package com.uphill.web.action.account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class Login implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++){
			String cookieName = cookies[i].getName();
			
			if(cookieName.equals("user_enter_id_cookie")){
				request.setAttribute("user_enter_id_cookie", cookies[i].getValue());
			}
			
			if(cookieName.equals("remember_id_cookie")){
				request.setAttribute("remember_id_cookie", cookies[i].getValue());
			}
		}
		
		return new ViewResolver("/views/account/login.tiles");
	}

}

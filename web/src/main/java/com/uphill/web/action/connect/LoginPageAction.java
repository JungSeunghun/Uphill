package com.uphill.web.action.connect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class LoginPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "connect/login";
	}

}

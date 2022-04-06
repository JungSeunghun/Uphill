package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("user_enter_id");		
		return "/home/home";
	}

}

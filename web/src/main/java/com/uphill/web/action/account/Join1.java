package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class Join1 implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
				
		return new ViewResolver("/views/account/join1.tiles");
	}

}

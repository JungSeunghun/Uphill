package com.uphill.web.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.common.ViewResolver;

public class HomeAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		ViewResolver viewResolver = new ViewResolver("home.tiles", true);
		
		return viewResolver;
	}
	
}

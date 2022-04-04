package com.uphill.web.action.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class CustomerCenter implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "/views/home/customer_center.tiles";
	}

}

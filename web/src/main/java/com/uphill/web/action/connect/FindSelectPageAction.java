package com.uphill.web.action.connect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class FindSelectPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "connect/find_select";
	}

}

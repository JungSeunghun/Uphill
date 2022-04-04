package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class FindSelect implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/views/account/find_select.tiles";
	}

}

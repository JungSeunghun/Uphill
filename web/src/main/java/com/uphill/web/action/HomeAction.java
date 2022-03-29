package com.uphill.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.common.ActionForward;

public class HomeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward("/home/home");
		
		return forward;
	}
	
}

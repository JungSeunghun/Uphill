package com.uphill.web.action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class Notice implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("snb", "community");
		
		return new ViewResolver("/views/community/notice.tiles");
	}

}

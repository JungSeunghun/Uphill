package com.uphill.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.viewresolver.ViewResolver;

public class Road implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		return new ViewResolver("/views/community/road.tiles");
	}

}

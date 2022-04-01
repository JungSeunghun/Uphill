package com.uphill.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.common.ViewResolver;

public interface Action {
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response);
}

package com.uphill.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.common.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}

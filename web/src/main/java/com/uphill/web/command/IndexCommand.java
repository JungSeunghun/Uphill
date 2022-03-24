package com.uphill.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "index/index";
	}

}

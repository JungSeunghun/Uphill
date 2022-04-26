package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.viewresolver.ViewResolver;

public class UserUpdate implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			return new ViewResolver("/views/user/userUpdate.tiles");
		} else {
			return new ViewResolver("/home/home", true);
		}
		
	}

}

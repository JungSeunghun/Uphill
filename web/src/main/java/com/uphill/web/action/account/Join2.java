package com.uphill.web.action.account;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.viewresolver.ViewResolver;

public class Join2 implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		UserVO userVO = new UserVO();
				
		String phoneNumber = request.getParameter("firstPhoneNumber") 
				+ request.getParameter("middlePhoneNumber")
				+ request.getParameter("lastPhoneNumber");

		userVO.setUserName(request.getParameter("userName"));
		userVO.setBirth(Date.valueOf(request.getParameter("birth")));
		userVO.setGender(request.getParameter("gender").charAt(0));
		userVO.setMobileCarrier(request.getParameter("mobileCarrier"));
		userVO.setPhoneNumber(phoneNumber);
		userVO.setPersonalAgree(Boolean.parseBoolean(request.getParameter("personalAgree")));
		userVO.setUniqueAgree(Boolean.parseBoolean(request.getParameter("uniqueAgree")));
		userVO.setMobileAgree(Boolean.parseBoolean(request.getParameter("mobileAgree")));
		userVO.setUseAgree(Boolean.parseBoolean(request.getParameter("useAgree")));
		
		session.setAttribute("userVO", userVO);
		
		return new ViewResolver("/views/account/join2.tiles");
	}

}

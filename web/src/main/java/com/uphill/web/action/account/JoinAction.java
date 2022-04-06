package com.uphill.web.action.account;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.JoinService;
import com.uphill.web.viewresolver.ViewResolver;

public class JoinAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		JoinService joinService = new JoinService();
		
		UserVO userVO = new UserVO();
		/*
		 * userVO.setUserEnterId("userEnterId"); userVO.setUserPassword("userPassword");
		 * userVO.setUserName("userName"); userVO.setGender('M');
		 * userVO.setBirth((Date)request.getParameter(""));
		 * userVO.setMobileCarrier("mobileCarrier");
		 * userVO.setPhoneNumber("phoneNumber"); userVO.setAddress("address");
		 * userVO.setEmail("email");
		 */
		
		joinService.join(userVO);
		
		return new ViewResolver("/views/account/join_finish.tiles");
	}

}

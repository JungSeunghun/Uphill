package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.JoinService;

public class JoinAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		JoinService joinService = new JoinService();
		
		UserVO userVO = new UserVO();
		
		userVO.setUserEnterId(userEnterId);
		userVO.setUserPassword(userPassword);
		userVO.setUserName(userName);
		userVO.setGender(gender);
		userVO.setBirth(birth);
		userVO.setMobileCarrier(mobileCarrier);
		userVO.setPhoneNumber(phoneNumber);
		userVO.setAddress(address);
		userVO.setEmail(email);
		
		
		joinService.join(userVO);
		
		return "/views/account/join_finish.tiles";
	}

}

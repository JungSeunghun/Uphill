package com.uphill.web.action.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.account.AccountServiceImpl;
import com.uphill.web.util.Email;
import com.uphill.web.util.SHA256Encoder;
import com.uphill.web.viewresolver.ViewResolver;

public class FindPasswordAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		String birthString = request.getParameter("year") + "-"
				+ request.getParameter("month") + "-"
				+ request.getParameter("day");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date birth = null;
		try {
			birth = dateFormat.parse(birthString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String phoneNumber = request.getParameter("firstPhoneNumber") 
				+ request.getParameter("middlePhoneNumber")
				+ request.getParameter("lastPhoneNumber");
		
		String email = request.getParameter("emailId") + request.getParameter("emailAddress");
		String userId = request.getParameter("userId");
		String userPassword = SHA256Encoder.getRandomPassword(8);
		
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setUserPassword(SHA256Encoder.encode(userPassword));
		userVO.setUserName(request.getParameter("userName"));
		userVO.setBirth(birth);
		userVO.setMobileCarrier(request.getParameter("mobileCarrier"));
		userVO.setPhoneNumber(phoneNumber);
		userVO.setEmail(email);
		
		AccountServiceImpl userService = new AccountServiceImpl();
		int result = userService.updatePassword(userVO);
		
		if(result > 0) {
			request.setAttribute("findPassword", true);
			Email.sendEmail(email, "Up-Hill 바뀐 비밀번호", "password : " + userPassword);
		} else {
			request.setAttribute("findPassword", false);			
		}
		
		return new ViewResolver("/views/account/findPasswordResult.tiles");
	}

}

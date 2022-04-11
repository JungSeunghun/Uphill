package com.uphill.web.action.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.FindPasswordService;
import com.uphill.web.service.account.UserIdFindService;
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
		
		UserVO userVO = new UserVO();
		userVO.setUserId(request.getParameter("userId"));
		userVO.setUserName(request.getParameter("userName"));
		userVO.setBirth(birth);
		userVO.setMobileCarrier(request.getParameter("mobileCarrier"));
		userVO.setPhoneNumber(phoneNumber);
		userVO.setEmail(email);
		String userPassword = SHA256Encoder.getRandomPassword(8);
		userVO.setUserPassword(userPassword);
		
		FindPasswordService findPasswordService = new FindPasswordService();
		boolean result = findPasswordService.updatePassword(userVO);
		
		if(result == true) {
			request.setAttribute("findPassword", true);
			Email.sendEmail(email, "Up-Hill 바뀐 비밀번호", "password : " + userPassword);
		} else {
			request.setAttribute("findPassword", false);			
		}
		
		return new ViewResolver("/views/account/findPasswordResult.tiles");
	}

}

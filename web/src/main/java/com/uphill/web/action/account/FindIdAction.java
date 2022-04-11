package com.uphill.web.action.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.UserIdFindService;
import com.uphill.web.viewresolver.ViewResolver;

public class FindIdAction implements Action {

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
		userVO.setUserName(request.getParameter("userName"));
		userVO.setBirth(birth);
		userVO.setMobileCarrier(request.getParameter("mobileCarrier"));
		userVO.setPhoneNumber(phoneNumber);
		userVO.setEmail(email);
		
		UserIdFindService userIdFindService = new UserIdFindService();
		String userId = userIdFindService.userIdFindService(userVO);
		
		if(!userId.equals("")) {
			request.setAttribute("userId", userId);
			request.setAttribute("findId", true);
		} else {
			request.setAttribute("findId", false);			
		}
					
		return new ViewResolver("/views/account/findIdResult.tiles");
	}

}

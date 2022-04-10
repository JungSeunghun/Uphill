package com.uphill.web.action.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		userVO.setUserName(request.getParameter("userName"));
		userVO.setBirth(birth);
		userVO.setGender(request.getParameter("gender").charAt(0));
		userVO.setMobileCarrier(request.getParameter("mobileCarrier"));
		userVO.setPhoneNumber(phoneNumber);
		userVO.setPersonalAgree(request.getParameter("personalAgree") != null ? true : false);
		userVO.setUniqueAgree(request.getParameter("uniqueAgree") != null ? true : false);
		userVO.setMobileAgree(request.getParameter("mobileAgree") != null ? true : false);
		userVO.setUseAgree(request.getParameter("useAgree") != null ? true : false);
		
		session.setAttribute("joinUserVO", userVO);
		
		return new ViewResolver("/views/account/join2.tiles");
	}

}

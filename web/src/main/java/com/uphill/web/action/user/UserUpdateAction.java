package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.user.UserService;
import com.uphill.web.service.user.UserServiceImpl;
import com.uphill.web.util.SHA256Encoder;
import com.uphill.web.viewresolver.ViewResolver;

public class UserUpdateAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO currentUserVO = null;
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			currentUserVO = (UserVO)session.getAttribute("userVO");			
		} else {
			return new ViewResolver("/home/home", true);
		}
		
		String userName = request.getParameter("userName");
		String userPassword = SHA256Encoder.encode(request.getParameter("userPassword"));
		String mobileCarrier = request.getParameter("mobileCarrier");
		String phoneNumber = request.getParameter("firstPhoneNumber") + request.getParameter("middlePhoneNumber") + request.getParameter("lastPhoneNumber");
		String postCode = request.getParameter("postCode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String addressExtra = request.getParameter("addressExtra");
		
		UserVO userVO = new UserVO();
		userVO.setUserIndex(currentUserVO.getUserIndex());
		userVO.setUserName(userName);
		userVO.setUserPassword(userPassword);
		userVO.setMobileCarrier(mobileCarrier);
		userVO.setPhoneNumber(phoneNumber);
		userVO.setPostCode(postCode);
		userVO.setAddress(address);
		userVO.setAddressDetail(addressDetail);
		userVO.setAddressExtra(addressExtra);
		
		UserService userService = new UserServiceImpl();
		UserVO newUserVO = userService.updateUser(userVO);
		session.setAttribute("userVO", newUserVO);
		
		return new ViewResolver("/user/user-update", true);
	}

}

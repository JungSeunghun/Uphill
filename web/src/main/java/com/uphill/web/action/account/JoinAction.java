package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.account.AccountServiceImpl;
import com.uphill.web.util.SHA256Encoder;
import com.uphill.web.viewresolver.ViewResolver;

public class JoinAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		UserVO userVO = new UserVO();
		
		if(session.getAttribute("joinUserVO") != null && session.getAttribute("joinUserVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("joinUserVO");
		} else {
			request.setAttribute("join", "false");
			session.removeAttribute("joinUserVO");
			return new ViewResolver("/account/login", true);
		}
		
		String userId = request.getParameter("userId");
		String userPassword = SHA256Encoder.encode(request.getParameter("userPassword"));
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String addressExtra = request.getParameter("addressExtra");
		String email = request.getParameter("emailId") + request.getParameter("emailAddress");
		
		userVO.setUserId(userId);
		userVO.setUserPassword(userPassword);
		userVO.setAddress(address);
		userVO.setAddressDetail(addressDetail);
		userVO.setAddressExtra(addressExtra);
		userVO.setEmail(email);
		
		AccountServiceImpl userService = new AccountServiceImpl();
		
		session.removeAttribute("joinUserVO");
		
		if(userService.join(userVO) > 0) {
			request.setAttribute("join", "true");
		} else {
			request.setAttribute("join", "false");			
		}

		return new ViewResolver("/account/login", true);		
	}

}

package com.uphill.web.action.account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.account.AccountServiceImpl;
import com.uphill.web.util.SHA256Encoder;
import com.uphill.web.viewresolver.ViewResolver;

public class LoginAction implements Action {
	
	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserVO userVO = new UserVO();
		
		String userId = request.getParameter("userId");
		String userPassword = SHA256Encoder.encode(request.getParameter("userPassword"));
		
		userVO.setUserId(userId);
		userVO.setUserPassword(userPassword);
		
		AccountServiceImpl accountService = new AccountServiceImpl();
		userVO = accountService.login(userVO);
				
		if(userVO != null) {
			Cookie userIdCookie = new Cookie("userIdCookie", request.getParameter("userId"));
			Cookie rememberIdCookie = new Cookie("rememberIdCookie", "checked");

			if(request.getParameter("rememberId") != null) {
				userIdCookie.setMaxAge(1*60*60*24);
				rememberIdCookie.setMaxAge(1*60*60*24);		
			} else {
				userIdCookie.setMaxAge(0);
				rememberIdCookie.setMaxAge(0);
			}
			
			response.addCookie(userIdCookie);
			response.addCookie(rememberIdCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			
			return new ViewResolver("/home/home", true);			
		} else {
			Cookie userIdCookie = new Cookie("userIdCookie", request.getParameter("userId"));
			Cookie rememberIdCookie = new Cookie("rememberIdCookie", "checked");

			if(request.getParameter("rememberId") != null) {
				userIdCookie.setMaxAge(1*60*60*24);
				rememberIdCookie.setMaxAge(1*60*60*24);		
			} else {
				userIdCookie.setMaxAge(0);
				rememberIdCookie.setMaxAge(0);
			}
			
			response.addCookie(userIdCookie);
			response.addCookie(rememberIdCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "fail");
			
			return new ViewResolver("/account/login", true);			
		}
		
	}

}

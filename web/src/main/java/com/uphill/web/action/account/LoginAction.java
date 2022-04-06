package com.uphill.web.action.account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.LoginService;
import com.uphill.web.viewresolver.ViewResolver;

public class LoginAction implements Action {
	
	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		LoginService loginService = new LoginService();
		
		UserVO userVO = new UserVO();
		
		userVO.setUserEnterId(request.getParameter("user_enter_id"));
		userVO.setUserPassword(request.getParameter("user_password"));
		
		boolean result = loginService.login(userVO);
				
		if(result) {
			Cookie userEnterIdCookie = new Cookie("user_enter_id_cookie", request.getParameter("user_enter_id"));
			Cookie rememberIdCookie = new Cookie("remember_id_cookie", "checked");

			if(request.getParameter("remember_id") != null) {
				userEnterIdCookie.setMaxAge(1*60*60*24);
				rememberIdCookie.setMaxAge(1*60*60*24);		
			} else {
				userEnterIdCookie.setMaxAge(0);
				rememberIdCookie.setMaxAge(0);
			}
			
			response.addCookie(userEnterIdCookie);
			response.addCookie(rememberIdCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("user_enter_id", request.getParameter("user_enter_id"));
			session.removeAttribute("login_fail");;
			
			return new ViewResolver("/home/home", true);			
		} else {
			Cookie userEnterIdCookie = new Cookie("user_enter_id_cookie", request.getParameter("user_enter_id"));
			Cookie rememberIdCookie = new Cookie("remember_id_cookie", "checked");

			if(request.getParameter("remember_id") != null) {
				userEnterIdCookie.setMaxAge(1*60*60*24);
				rememberIdCookie.setMaxAge(1*60*60*24);		
			} else {
				userEnterIdCookie.setMaxAge(0);
				rememberIdCookie.setMaxAge(0);
			}
			
			response.addCookie(userEnterIdCookie);
			response.addCookie(rememberIdCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("login_fail", "fail");
			
			return new ViewResolver("/account/login", true);			
		}
		
	}

}

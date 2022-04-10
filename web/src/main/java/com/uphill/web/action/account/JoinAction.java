package com.uphill.web.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.service.account.JoinService;
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
			session.removeAttribute("joinUserVO");
			return new ViewResolver("/views/account/joinFinish.tiles");
		}
		
		String email = request.getParameter("emailId") + request.getParameter("emailAddress");

		String salt = SHA256Encoder.getRandomPassword(8);
		
		userVO.setSalt(salt);
		userVO.setUserId(request.getParameter("userId"));
		userVO.setUserPassword(SHA256Encoder.encode(request.getParameter("userPassword"), salt));
		userVO.setAddress(request.getParameter("address"));
		userVO.setAddressDetail(request.getParameter("addressDetail"));
		userVO.setAddressExtra(request.getParameter("addressExtra"));
		userVO.setEmail(email);
		
		JoinService joinService = new JoinService();
		
		session.removeAttribute("joinUserVO");
		
		if(joinService.join(userVO) == true) {
			request.setAttribute("join", "join");
		}
		
		return new ViewResolver("/views/account/joinFinish.tiles");		
	}

}

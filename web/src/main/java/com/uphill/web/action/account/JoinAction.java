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
		
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/views/account/join_fail.tiles");
		}
		String email = request.getParameter("emailId") + request.getParameter("emailAddress");

		String salt = SHA256Encoder.getRandomPassword(8);
		
		userVO.setSalt(salt);
		userVO.setUserEnterId(request.getParameter("userEnterId"));
		userVO.setUserPassword(SHA256Encoder.encode(request.getParameter("userPassword"), salt));
		userVO.setAddress(request.getParameter("address"));
		userVO.setAddressDetail(request.getParameter("addressDetail"));
		userVO.setEmail(email);
		
		JoinService joinService = new JoinService();
		
		if(joinService.join(userVO)) {
			return new ViewResolver("/views/account/join_finish.tiles");
		} else {
			return new ViewResolver("/views/account/join_fail.tiles");
		}
		
	}

}

package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.order.OrderService;
import com.uphill.web.service.order.OrderServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class OrderAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));	
		String optionName = request.getParameter("optionName");
		int optionQty = Integer.parseInt(request.getParameter("optionQty"));
		int optionPrice = Integer.parseInt(request.getParameter("optionPrice"));
		
		OrderItemVO orderItemVO = new OrderItemVO(0, itemIndex, optionName, optionQty, optionPrice);
		
		HttpSession session = request.getSession();
		UserVO userVO = null;
		
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/home/home", true);
		}
		
		int userIndex = userVO.getUserIndex();
		String userId = userVO.getUserId();
		String recipient = request.getParameter("recipient");
		String postCode = request.getParameter("postCode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String addressExtra = request.getParameter("addressExtra");
		String mobileCarrier = request.getParameter("mobileCarrier");
		String phoneNumber = request.getParameter("firstPhoneNumber") + request.getParameter("middlePhoneNumber") + request.getParameter("lastPhoneNumber");
		int point = (int)Float.parseFloat(request.getParameter("point"));
		int usePoint = Integer.parseInt(request.getParameter("usePoint"));
		String deliverRequest = request.getParameter("deliverRequest");
		String payment = request.getParameter("payment");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice")) - usePoint;
		
		OrderVO orderVO = new OrderVO(userIndex, userId, recipient, postCode, address, addressDetail, addressExtra, mobileCarrier, phoneNumber, point, usePoint, deliverRequest, payment, totalPrice);
		
		OrderService orderService = new OrderServiceImpl();
		UserVO newUserVO = orderService.order(orderVO, orderItemVO, userVO.getPurchase());
		session.setAttribute("userVO", newUserVO);
		
		return new ViewResolver("/user/order-list", true);
	}

}

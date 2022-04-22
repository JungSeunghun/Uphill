package com.uphill.web.action.user;

import java.util.ArrayList;
import java.util.List;

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

public class OrderBasketAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		String[] itemIndexStringArray = request.getParameterValues("itemIndex");	
		String[] optionNameArray = request.getParameterValues("optionName");
		String[] optionQtyStringArray = request.getParameterValues("optionQty");
		String[] optionPriceStringArray = request.getParameterValues("optionPrice");
		
		int[] itemIndexArray = new int[itemIndexStringArray.length];	
		for(int i = 0; i < itemIndexArray.length; i++) {
			itemIndexArray[i] = Integer.parseInt(itemIndexStringArray[i]); 
		}
		int[] optionQtyArray = new int[optionQtyStringArray.length];	
		for(int i = 0; i < optionQtyArray.length; i++) {
			optionQtyArray[i] = Integer.parseInt(optionQtyStringArray[i]); 
		}
		int[] optionPriceArray = new int[optionPriceStringArray.length];
		for(int i = 0; i < optionPriceStringArray.length; i++) {
			optionPriceArray[i] = Integer.parseInt(optionPriceStringArray[i]); 
		}
		
		List<OrderItemVO> orderItemList = new ArrayList<OrderItemVO>();
		for(int i = 0; i < itemIndexArray.length; i++) {
			int itemIndex = itemIndexArray[i];
			String optionName = optionNameArray[i];
			int optionQty = optionQtyArray[i];
			int optionPrice = optionPriceArray[i];
			
			orderItemList.add(new OrderItemVO(0, itemIndex, optionName, optionQty, optionPrice));
		}

		HttpSession session = request.getSession();
		UserVO userVO = null;
		
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/home/home", true);
		}
		
		int userIndex = userVO.getUserIndex();
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
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice")) - point;
		
		OrderVO orderVO = new OrderVO(userIndex, recipient, postCode, address, addressDetail, addressExtra, mobileCarrier, phoneNumber, point, usePoint, deliverRequest, payment, totalPrice);
		
		OrderService orderService = new OrderServiceImpl();
		orderService.orderBasket(orderVO, orderItemList, userVO.getPurchase());
		
		return new ViewResolver("/user/purchaseList");
	}

}

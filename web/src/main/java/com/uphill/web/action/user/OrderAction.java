package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class OrderAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		String[] itemIndex = request.getParameterValues("itemIndex");
		String[] itemName = request.getParameterValues("itemName");
		String[] optionName = request.getParameterValues("optionName");
		String[] optionQty = request.getParameterValues("optionQty");
		String[] optionPrice = request.getParameterValues("optionPrice");
		
		String recipient = request.getParameter("recipient");
		String postCode = request.getParameter("postCode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String addressExtra = request.getParameter("addressExtra");
		String mobileCarrier = request.getParameter("mobileCarrier");
		String firstPhoneNumber = request.getParameter("firstPhoneNumber");
		String middlePhoneNumber = request.getParameter("middlePhoneNumber");
		String lastPhoneNumber = request.getParameter("lastPhoneNumber");
		int usePoint = Integer.parseInt(request.getParameter("usePoint"));
		String deliverRequest = request.getParameter("deliverRequest");
		String payment = request.getParameter("payment");
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		
		return new ViewResolver("/user/purchaseList");
	}

}

package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class PurchaseList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new ViewResolver("/views/user/purchaseList.tiles");
	}

}

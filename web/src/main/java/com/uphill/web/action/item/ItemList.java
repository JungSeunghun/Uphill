package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
				
		return new ViewResolver("/views/item/item_list.tiles");
	}

}

package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class ItemListPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
				
		return "item/item_list";
	}

}

package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;

public class ItemList implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
				
		return "/views/item/item_list.tiles";
	}

}

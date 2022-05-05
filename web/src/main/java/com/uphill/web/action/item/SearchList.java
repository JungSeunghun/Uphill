package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class SearchList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		String search = request.getParameter("search");
		
		ItemService itemService = new ItemServiceImpl();
		List<ItemVO> itemList = itemService.getSearchList(search);
		
		request.setAttribute("itemList", itemList);
		
		return new ViewResolver("views/item/searchList.tiles");
	}

}

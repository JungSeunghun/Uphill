package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.item.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.viewresolver.ViewResolver;

public class LockList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		ItemService itemService = new ItemService();
		List<ItemVO> lockList = itemService.getItemListWithCategory(4);
		
		request.setAttribute("itemList", lockList);		
		
		return new ViewResolver("/views/item/itemList.tiles");
	}

}

package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.item.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.viewresolver.ViewResolver;

public class HelmetList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		ItemService itemService = new ItemService();
		List<ItemVO> helmetList = itemService.getItemListWithCategory(2);
		
		request.setAttribute("itemList", helmetList);		
		
		return new ViewResolver("/views/item/itemList.tiles");
	}

}

package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.viewresolver.ViewResolver;

public class MiniveloList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		ItemService itemService = new ItemService();
		List<ItemVO> miniveloList = itemService.getItemListWithCategoryAndSubcategory(1, 3);
		
		request.setAttribute("itemList", miniveloList);		
		
		return new ViewResolver("/views/item/bicycleList.tiles");
	}

}

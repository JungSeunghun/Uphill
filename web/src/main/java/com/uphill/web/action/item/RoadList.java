package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class RoadList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		ItemService itemService = new ItemServiceImpl();
		List<ItemVO> roadList = itemService.getBicycleListWithSubcategory(2);
		
		request.setAttribute("itemList", roadList);		
		
		return new ViewResolver("/views/item/bicycleList.tiles");
	}

}

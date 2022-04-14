package com.uphill.web.action.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemInfo implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		
		ItemService itemService = new ItemService();
		ItemPostVO itemPost = itemService.getItemPost(id);
		ItemVO item = itemService.getItem(id);
		List<String> itemOptionNameList = itemService.getItemOptionNameList(id);
		List<ItemOptionVO> itemOptionList = itemService.getItemOptionList(id);
		
		request.setAttribute("itemPost", itemPost);
		request.setAttribute("item", item);
		request.setAttribute("itemOptionNameList", itemOptionNameList);
		request.setAttribute("itemOptionList", itemOptionList);
		
		if(item.getItemCategoryIndex() == 1) {
			request.setAttribute("snb", "bicycle");
		} else {
			request.setAttribute("snb", "item");			
		}
		
		return new ViewResolver("/views/item/itemInfo.tiles");
	}

}

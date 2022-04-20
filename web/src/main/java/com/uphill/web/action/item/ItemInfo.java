package com.uphill.web.action.item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostInfoVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemInfo implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		
		ItemService itemService = new ItemServiceImpl();
		ItemPostInfoVO itemPostInfo = itemService.getItemPost(id);
		ItemPostVO itemPost = itemPostInfo.getItemPostVO();
		ItemVO item = itemPostInfo.getItemVO();
		List<ItemOptionVO> itemOptionList = itemPostInfo.getItemOptionList();
		
		// 옵션이름 중복제거
		HashSet<String> itemOptionNameSet = new HashSet<String>();		
		for(ItemOptionVO itemOptionVO : itemOptionList) {
			itemOptionNameSet.add(itemOptionVO.getItemOptionName());
		}
		
		List<String> itemOptionNameList = new ArrayList<String>(itemOptionNameSet);
		
		request.setAttribute("itemPost", itemPost);
		request.setAttribute("item", item);
		request.setAttribute("itemOptionNameList", itemOptionNameList);
		request.setAttribute("itemOptionList", itemOptionList);
		
		if(item.getItemCategoryIndex() == 1) {
			return new ViewResolver("/views/item/bicycleInfo.tiles");
		} else {
			return new ViewResolver("/views/item/itemInfo.tiles");
		}
		
	}

}

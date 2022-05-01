package com.uphill.web.action.item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.AskVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostInfoVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.ReviewVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemInfo implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {

		int itemIndex = Integer.parseInt(request.getParameter("id"));
		int reviewPage = 1;
		int askPage = 1;
		int reviewCount = 5;
		int askCount = 5;
		if(request.getParameter("reviewPage") != null) {
			reviewPage = Integer.parseInt(request.getParameter("reviewPage"));
		}
		if(request.getParameter("askPage") != null) {
			askPage = Integer.parseInt(request.getParameter("askPage"));			
		}
		
		ItemService itemService = new ItemServiceImpl();
		ItemPostInfoVO itemPostInfo = itemService.getItemPost(itemIndex, reviewPage, reviewCount, askPage, askCount);
		ItemPostVO itemPost = itemPostInfo.getItemPostVO();
		ItemVO item = itemPostInfo.getItemVO();
		List<ItemOptionVO> itemOptionList = itemPostInfo.getItemOptionList();
		List<ReviewVO> reviewList = itemPostInfo.getReviewList();
		List<AskVO> askList = itemPostInfo.getAskList();
		int totalReviewCount = itemPostInfo.getReviewCount();
		int totalAskCount = itemPostInfo.getAskCount();
		
		// 페이징
		int pageCount = 5;
		
		int reviewEndPage = (int)Math.ceil(((double)reviewPage / pageCount)) * pageCount;
		int reviewStartPage = reviewEndPage - pageCount + 1;
		int reviewMaxPage = (int)Math.ceil((double)totalReviewCount / reviewCount);
		if(reviewEndPage > reviewMaxPage) {
			reviewEndPage = reviewMaxPage;
		}
		
		int askEndPage = (int)Math.ceil(((double)askPage / pageCount)) * pageCount;
		int askStartPage = askEndPage - pageCount + 1;
		int askMaxPage = (int)Math.ceil((double)totalAskCount / askCount);
		if(askEndPage > askMaxPage) {
			askEndPage = askMaxPage;
		}		
		
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
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("askList", askList);
		request.setAttribute("reviewPage", reviewPage);
		request.setAttribute("reviewStartPage", reviewStartPage);
		request.setAttribute("reviewEndPage", reviewEndPage);
		request.setAttribute("reviewMaxPage", reviewMaxPage);
		request.setAttribute("askPage", askPage);
		request.setAttribute("askStartPage", askStartPage);
		request.setAttribute("askEndPage", askEndPage);
		request.setAttribute("askMaxPage", askMaxPage);
		
		if(item.getItemCategoryIndex() == 1) {
			return new ViewResolver("/views/item/bicycleInfo.tiles");
		} else {
			return new ViewResolver("/views/item/itemInfo.tiles");
		}
		
	}

}

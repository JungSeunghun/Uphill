package com.uphill.web.service.home;

import java.util.List;

import com.uphill.web.dao.ItemDAO;
import com.uphill.web.dto.item.ItemVO;

public class HomeService {
	
	public List<ItemVO> getBestSellerList(int categoryIndex, int count) {
		ItemDAO itemDAO = new ItemDAO();
		return itemDAO.selectBestSellerList(categoryIndex, count);
	}
	
	public List<ItemVO> getBestItemList(int count) {
		ItemDAO itemDAO = new ItemDAO();
		return itemDAO.selectBestItemList(count);
	}
	
}

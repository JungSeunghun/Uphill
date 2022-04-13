package com.uphill.web.service.item;

import java.util.List;

import com.uphill.web.dao.ItemDAO;
import com.uphill.web.dto.item.ItemVO;

public class ItemService {

	public List<ItemVO> getItemListWithCategory(int categoryIndex) {
		
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectItemListWithCategory(categoryIndex);
	}
	
	public List<ItemVO> getItemListWithCategoryAndSubcategory(int categoryIndex, int subcategoryIndex) {
		
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectItemListWithCategoryAndSubcategory(categoryIndex, subcategoryIndex);
	}

	public List<ItemVO> getItemListExceptCategory(int categoryIndex) {
		
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectItemListExceptCategory(categoryIndex);
	}

}

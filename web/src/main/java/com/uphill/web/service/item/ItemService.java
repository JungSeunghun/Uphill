package com.uphill.web.service.item;

import java.util.List;

import com.uphill.web.dao.ItemDAO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;

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

	public ItemPostVO getItemPost(int id) {
		
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectItemPost(id);
	}

	public ItemVO getItem(int id) {

		ItemDAO itemDAO = new ItemDAO();
				
		return itemDAO.selectItem(id);
	}
	
	public List<String> getItemOptionNameList(int id) {
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectItemOptionNameList(id);
	}

	public List<ItemOptionVO> getItemOptionList(int id) {

		ItemDAO itemDAO = new ItemDAO();
				
		return itemDAO.selectItemOptionList(id);
	}

}

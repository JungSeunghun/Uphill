package com.uphill.web.data.item.dao;

import java.util.List;

import com.uphill.web.data.item.dto.ItemVO;

public class ItemDAO {
	List<ItemVO> selectAllItems() {
		return null;
	}
	
	List<ItemVO> selectItemsByCategory(int itemCategoryId) {
		return null;
	}

	List<ItemVO> selectItemsByCategory(int itemCategoryId, int itemSubcategory) {
		return null;
	}
	
	List<ItemVO> selectBestSellers(int itemCategoryId) {
		return null;
	}
	
	List<ItemVO> selectItems(String itemName) {
		return null;
	}
	
	ItemVO selectItem(int itemId) {
		return null;
	}
	
	boolean insertItem(ItemVO itemVO) {
		return false;
	}

	boolean updateItem(ItemVO itemVO) {
		return false;
	}
	
	boolean deleteItem(ItemVO itemVO) {
		return false;
	}
		
}

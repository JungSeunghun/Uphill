package com.uphill.web.data.item.dao;

import java.util.List;

import com.uphill.web.data.item.dto.ItemVO;

public class ItemDAO {
	List<ItemVO> selectItemList() {
		return null;
	}
	
	List<ItemVO> selectItemList(String itemName) {
		return null;
	}
	
	List<ItemVO> selectItemListByCategory(int itemCategoryId) {
		return null;
	}

	List<ItemVO> selectItemListByCategory(int itemCategoryId, int itemSubcategory) {
		return null;
	}
	
	List<ItemVO> selectBestSellerList(int itemCategoryId) {
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

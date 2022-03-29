package com.uphill.web.data.item.service;

import java.util.List;

import com.uphill.web.data.item.dto.ItemVO;

public interface ItemService {
	List<ItemVO> getAllItems();
	List<ItemVO> getItemsByCategory(int itemCategoryId);
	List<ItemVO> getItemsByCategory(int itemCategory, int itemSubcategory);
	List<ItemVO> getBestSellers(int itemCategoryId);
	List<ItemVO> searchItems(String itemName);
	ItemVO getItem(int itemId);
	boolean registItem(ItemVO itemVO);
	boolean updateItem(ItemVO itemVO);
	boolean deleteItem(ItemVO itemVO);
}

package com.uphill.web.data.item.service;

import java.util.List;

import com.uphill.web.data.item.dto.ItemVO;

public interface ItemService {
	List<ItemVO> getItemList();
	List<ItemVO> getItemList(String itemName);
	List<ItemVO> getItemListByCategory(int itemCategoryId);
	List<ItemVO> getItemListByCategory(int itemCategory, int itemSubcategory);
	List<ItemVO> getBestSellerList(int itemCategoryId);
	ItemVO getItem(int itemId);
	boolean registItem(ItemVO itemVO);
	boolean updateItem(ItemVO itemVO);
	boolean deleteItem(ItemVO itemVO);
}

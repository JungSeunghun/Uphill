package com.uphill.web.data.itemcategory.service;

import java.util.List;

import com.uphill.web.data.itemcategory.dto.ItemCategoryVO;

public interface ItemCategoryService {
	List<ItemCategoryVO> getItemCategoryList();
	ItemCategoryVO getItemCategory();
	boolean registItemCategory(ItemCategoryVO itemCategoryVO);
	boolean updateItemCategory(ItemCategoryVO itemCategoryVO);
	boolean deleteItemCategory(ItemCategoryVO itemCategoryVO);
}

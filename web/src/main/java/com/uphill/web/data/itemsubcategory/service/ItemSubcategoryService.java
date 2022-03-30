package com.uphill.web.data.itemsubcategory.service;

import java.util.List;

import com.uphill.web.data.itemsubcategory.dto.ItemSubcategoryVO;

public interface ItemSubcategoryService {
	List<ItemSubcategoryVO> getItemSubcategoryList();
	ItemSubcategoryVO getItemSubcategory();
	boolean registItemSubcategory(ItemSubcategoryVO itemSubcategoryVO);
	boolean updateItemSubcategory(ItemSubcategoryVO itemSubcategoryVO);
	boolean deleteItemSubcategory(ItemSubcategoryVO itemSubcategoryVO);
}

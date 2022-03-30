package com.uphill.web.data.item.service;

import java.util.List;

import com.uphill.web.data.item.dto.ItemVO;

public class ItemServiceImplement implements ItemService {

	@Override
	public List<ItemVO> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ItemVO> getItemList(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemVO> getItemListByCategory(int itemCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemVO> getItemListByCategory(int itemCategory, int itemSubcategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemVO> getBestSellerList(int itemCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemVO getItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registItem(ItemVO itemVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(ItemVO itemVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(ItemVO itemVO) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

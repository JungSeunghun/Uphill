package com.uphill.web.service.item;

import java.util.List;

import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostInfoVO;
import com.uphill.web.dto.ItemVO;

public interface ItemService {
	ItemVO getItem(int id);
	List<ItemVO> getItemList();	
	List<ItemVO> getItemListWithCategory(int categoryIndex);	
	List<ItemVO> getBicycleList();	
	List<ItemVO> getBicycleListWithSubcategory(int subcategoryIndex);
	ItemPostInfoVO getItemPost(int id);
	List<ItemOptionVO> getItemOptionList(int id);
}

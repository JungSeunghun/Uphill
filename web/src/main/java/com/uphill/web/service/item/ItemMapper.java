package com.uphill.web.service.item;

import java.util.List;

import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;

public interface ItemMapper {
	ItemVO selectItem(int id);
	List<ItemVO> selectItemList();	
	List<ItemVO> selectItemListWithCategory(int categoryIndex);	
	List<ItemVO> selectBicycleList();	
	List<ItemVO> selectBicycleListWithSubcategory(int subcategoryIndex);
	ItemPostVO selectItemPost(int itemIndex);
	List<ItemOptionVO> selectItemOptionList(int itemIndex);
}

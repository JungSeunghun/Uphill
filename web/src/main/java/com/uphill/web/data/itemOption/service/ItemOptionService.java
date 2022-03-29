package com.uphill.web.data.itemOption.service;

import java.util.List;

import com.uphill.web.data.itemOption.dto.ItemOptionVO;

public interface ItemOptionService {
	List<ItemOptionVO> getAllItemOptions();
	ItemOptionVO getItemOption(int ItemOptionId);
	boolean registItemOption(ItemOptionVO itemOptionVO);
	boolean updateItemOption(ItemOptionVO itemOptionVO);
	boolean deleteItemOption(ItemOptionVO itemOptionVO);
}

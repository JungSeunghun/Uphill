package com.uphill.web.data.itemoption.service;

import java.util.List;

import com.uphill.web.data.itemoption.dto.ItemOptionVO;

public interface ItemOptionService {
	List<ItemOptionVO> getItemOptionList();
	ItemOptionVO getItemOption(int ItemOptionId);
	boolean registItemOption(ItemOptionVO itemOptionVO);
	boolean updateItemOption(ItemOptionVO itemOptionVO);
	boolean deleteItemOption(ItemOptionVO itemOptionVO);
}

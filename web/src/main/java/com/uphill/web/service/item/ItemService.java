package com.uphill.web.service.item;

import java.util.List;

import com.uphill.web.dto.AskVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostInfoVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.ReviewVO;

public interface ItemService {
	ItemVO getItem(int itemIndex);
	List<ItemVO> getItemList();	
	List<ItemVO> getItemListWithCategory(int categoryIndex);	
	List<ItemVO> getBicycleList();	
	List<ItemVO> getBicycleListWithSubcategory(int subcategoryIndex);
	ItemPostInfoVO getItemPost(int itemIndex, int reviewPage, int reviewCount, int askPage, int askCount);
	List<ItemOptionVO> getItemOptionList(int itemIndex);
	int insertReview(ReviewVO reviewVO);
	int insertAsk(AskVO askVO);
	int deleteReview(int reviewIndex);
	int deleteAsk(int askIndex);
}

package com.uphill.web.service.item;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.AskVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.ReviewVO;

public interface ItemMapper {
	ItemVO selectItem(int id);
	List<ItemVO> selectItemList();	
	List<ItemVO> selectItemListWithCategory(int categoryIndex);	
	List<ItemVO> selectBicycleList();	
	List<ItemVO> selectBicycleListWithSubcategory(int subcategoryIndex);
	ItemPostVO selectItemPost(int itemIndex);
	List<ItemOptionVO> selectItemOptionList(int itemIndex);
	List<ReviewVO> selectReviewList(Map<String, Integer> map);
	List<AskVO> selectAskList(Map<String, Integer> map);
	int selectReviewCount(int itemIndex);
	int selectAskCount(int itemIndex);
	int insertReview(ReviewVO reviewVO);
	int selectAskIndex();
	int insertAsk(AskVO askVO);
	int deleteReview(int reviewIndex);
	int deleteAsk(int askIndex);
}

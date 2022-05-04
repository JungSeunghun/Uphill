package com.uphill.web.service.admin;

import java.util.List;

import com.uphill.web.dto.ItemInfoVO;
import com.uphill.web.dto.ItemListInfoVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.OrderInfoVO;
import com.uphill.web.dto.OrderListInfoVO;
import com.uphill.web.dto.UserListInfoVO;
import com.uphill.web.dto.UserVO;

public interface AdminService {
	UserListInfoVO getUserListInfo(int page, int count);
	UserVO getUserInfo(int userIndex);
	int deleteUser(int userIndex);
	
	OrderListInfoVO getOrderListInfo(int orderPage, int count);
	OrderInfoVO getOrderInfo(int orderIndex);
	int updateOrder(int orderState, int orderIndex);
	
	ItemListInfoVO getItemListInfo(int itemPage, int count);
	ItemInfoVO getItemInfo(int itemIndex);
	int updateItem(ItemVO itemVO, List<ItemOptionVO> itemOptionList);
	int insertItem(ItemVO itemVO, List<ItemOptionVO> itemOptionList);
	int deleteItem(int itemIndex);
}

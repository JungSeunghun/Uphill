package com.uphill.web.service.admin;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.OrderItemInfoVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;

public interface AdminMapper {
	List<UserVO> selectUserList(Map<String, Integer> map);
	UserVO selectUser(int userIndex);
	int deleteUser(int userIndex);
	int selectUserCount();
	
	List<OrderVO> selectOrderList(Map<String, Integer> map);
	OrderVO selectOrder(int orderIndex);
	int updateOrder(Map<String, Integer> map);
	int selectOrderCount();
	List<OrderItemInfoVO> selectOrderItemInfoList(int orderIndex);
	
	List<ItemVO> selectItemList(Map<String, Integer> map);
	int selectItemCount();
	ItemVO selectItem(int itemIndex);
	List<ItemOptionVO> selectItemOptionList(int itemIndex);
}
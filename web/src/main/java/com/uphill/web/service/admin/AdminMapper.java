package com.uphill.web.service.admin;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.UserVO;

public interface AdminMapper {
	List<UserVO> selectUserList(Map<String, Integer> map);
	UserVO selectUser(int userIndex);
	int deleteUser(int userIndex);
	int selectUserCount();
}
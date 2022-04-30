package com.uphill.web.service.admin;

import java.util.List;

import com.uphill.web.dto.UserVO;

public interface AdminMapper {
	List<UserVO> selectUserList();
	UserVO selectUser(int userIndex);
	int deleteUser(int userIndex);
}
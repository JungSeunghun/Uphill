package com.uphill.web.service.admin;

import java.util.List;

import com.uphill.web.dto.UserVO;

public interface AdminService {
	List<UserVO> getUserList();
	UserVO getUserInfo(int userIndex);
	int deleteUser(int userIndex);
}

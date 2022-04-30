package com.uphill.web.service.admin;

import java.util.List;

import com.uphill.web.dto.UserListInfoVO;
import com.uphill.web.dto.UserVO;

public interface AdminService {
	UserListInfoVO getUserList(int page, int count);
	UserVO getUserInfo(int userIndex);
	int deleteUser(int userIndex);
}

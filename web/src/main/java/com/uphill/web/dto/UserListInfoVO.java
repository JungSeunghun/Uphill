package com.uphill.web.dto;

import java.util.List;

public class UserListInfoVO {
	List<UserVO> userList;
	int totalCount;
	
	public UserListInfoVO() {
		super();
	}

	public UserListInfoVO(List<UserVO> userList, int totalCount) {
		super();
		this.userList = userList;
		this.totalCount = totalCount;
	}

	public List<UserVO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}

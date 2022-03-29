package com.uphill.web.data.member.dto;

import java.util.Date;

public class MemberVO {
	private int userId;
	private int gradeId;
	private String userEnterId;
	private String userPassword;
	private String userName;
	private char gender;
	private String mobileCarrier;
	private String phoneNumber;
	private String address;
	private String email;
	private int purchase;
	private int point;
	private Date joinDate;
	private Date leaveDate;
	
	public MemberVO() {}
	
	public MemberVO(int userId, int gradeId, String userEnterId, String userPassword, String userName, char gender,
			String mobileCarrier, String phoneNumber, String address, String email, int purchase, int point,
			Date joinDate, Date leaveDate) {
		super();
		this.userId = userId;
		this.gradeId = gradeId;
		this.userEnterId = userEnterId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.gender = gender;
		this.mobileCarrier = mobileCarrier;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.purchase = purchase;
		this.point = point;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getUserEnterId() {
		return userEnterId;
	}

	public void setUserEnterId(String userEnterId) {
		this.userEnterId = userEnterId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobileCarrier() {
		return mobileCarrier;
	}

	public void setMobileCarrier(String mobileCarrier) {
		this.mobileCarrier = mobileCarrier;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	
	
}

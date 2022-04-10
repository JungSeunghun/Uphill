package com.uphill.web.dto.user;

import java.util.Date;

public class UserVO {
	private int userId;
	private int gradeId;
	private String userEnterId;
	private String userPassword;
	private String userName;
	private char gender;
	private Date birth;
	private String mobileCarrier;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String addressExtra;
	private String email;
	private boolean personalAgree;
	private boolean uniqueAgree;
	private boolean mobileAgree;
	private boolean useAgree;
	private int purchase;
	private int point;
	private Date joinDate;
	private Date leaveDate;
	private String salt;
	
	public UserVO() {
		super();
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
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

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressExtra() {
		return addressExtra;
	}
	
	public void setAddressExtra(String addressExtra) {
		this.addressExtra = addressExtra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPersonalAgree() {
		return personalAgree;
	}

	public void setPersonalAgree(boolean personalAgree) {
		this.personalAgree = personalAgree;
	}

	public boolean isUniqueAgree() {
		return uniqueAgree;
	}

	public void setUniqueAgree(boolean uniqueAgree) {
		this.uniqueAgree = uniqueAgree;
	}

	public boolean isMobileAgree() {
		return mobileAgree;
	}

	public void setMobileAgree(boolean mobileAgree) {
		this.mobileAgree = mobileAgree;
	}

	public boolean isUseAgree() {
		return useAgree;
	}

	public void setUseAgree(boolean useAgree) {
		this.useAgree = useAgree;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}

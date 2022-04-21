package com.uphill.web.dto;

import java.util.Date;

public class OrderVO {
	private int orderIndex;
	private int userIndex;
	private String recipient;
	private String postCode;
	private String address;
	private String addressDetail;
	private String addressExtra;
	private String mobileCarrier;
	private String phoneNumber;
	private int point;
	private int usePoint;
	private String deliverRequest;
	private String payment;
	private int totalPrice;
	private Date orderTime;
	private int orderState;
	
	public OrderVO() {
		super();
	}
	
	public OrderVO(int userIndex, String recipient, String postCode, String address, String addressDetail,
			String addressExtra, String mobileCarrier, String phoneNumber, int point, int usePoint,
			String deliverRequest, String payment, int totalPrice) {
		super();
		this.userIndex = userIndex;
		this.recipient = recipient;
		this.postCode = postCode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.addressExtra = addressExtra;
		this.mobileCarrier = mobileCarrier;
		this.phoneNumber = phoneNumber;
		this.point = point;
		this.usePoint = usePoint;
		this.deliverRequest = deliverRequest;
		this.payment = payment;
		this.totalPrice = totalPrice;
	}

	public OrderVO(int orderIndex, int userIndex, String recipient, String postCode, String address,
			String addressDetail, String addressExtra, String mobileCarrier, String phoneNumber, int point,
			int usePoint, String deliverRequest, String payment, int totalPrice, Date orderTime, int orderState) {
		super();
		this.orderIndex = orderIndex;
		this.userIndex = userIndex;
		this.recipient = recipient;
		this.postCode = postCode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.addressExtra = addressExtra;
		this.mobileCarrier = mobileCarrier;
		this.phoneNumber = phoneNumber;
		this.point = point;
		this.usePoint = usePoint;
		this.deliverRequest = deliverRequest;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.orderState = orderState;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public String getDeliverRequest() {
		return deliverRequest;
	}

	public void setDeliverRequest(String deliverRequest) {
		this.deliverRequest = deliverRequest;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

}

package com.uphill.web.data.order.dto;

import java.util.Date;

public class OrderVO {
	private int orderId;
	private int userId;
	private int itemId;
	private int itemQty;
	private int itemPrice;
	private int itemDiscountPrice;
	private int itemDiscountPercent;
	private Date orderDate;
	private Date orderCompleteDate;
	private String payment;
	private String deliveryAddress;
	private String request;
	
	public OrderVO() {}
	
	public OrderVO(int orderId, int userId, int itemId, int itemQty, int itemPrice, int itemDiscountPrice,
			int itemDiscountPercent, Date orderDate, Date orderCompleteDate, String payment, String deliveryAddress,
			String request) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemQty = itemQty;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
		this.itemDiscountPercent = itemDiscountPercent;
		this.orderDate = orderDate;
		this.orderCompleteDate = orderCompleteDate;
		this.payment = payment;
		this.deliveryAddress = deliveryAddress;
		this.request = request;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemDiscountPrice() {
		return itemDiscountPrice;
	}

	public void setItemDiscountPrice(int itemDiscountPrice) {
		this.itemDiscountPrice = itemDiscountPrice;
	}

	public int getItemDiscountPercent() {
		return itemDiscountPercent;
	}

	public void setItemDiscountPercent(int itemDiscountPercent) {
		this.itemDiscountPercent = itemDiscountPercent;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderCompleteDate() {
		return orderCompleteDate;
	}

	public void setOrderCompleteDate(Date orderCompleteDate) {
		this.orderCompleteDate = orderCompleteDate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
	
	
}

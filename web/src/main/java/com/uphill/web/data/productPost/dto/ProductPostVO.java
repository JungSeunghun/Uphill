package com.uphill.web.data.productPost.dto;

import java.util.Date;

public class ProductPostVO {
	private int productPostId;
	private int itemId;
	private int userId;
	private Date postDate;
	private String title;
	private String content;
	private String imageFile;
	private int hits;
	
	public ProductPostVO(int productPostId, int itemId, int userId, Date postDate, String title, String content,
			String imageFile, int hits) {
		super();
		this.productPostId = productPostId;
		this.itemId = itemId;
		this.userId = userId;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
		this.hits = hits;
	}

	public int getProductPostId() {
		return productPostId;
	}

	public void setProductPostId(int productPostId) {
		this.productPostId = productPostId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}

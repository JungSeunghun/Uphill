package com.uphill.web.dto.itempost;

import java.util.Date;

public class ItemPostVO {
	private int itemPostIndex;
	private int itemIndex;
	private String userId;
	private Date postDate;
	private String title;
	private String content;
	private String imageFile;
	private int hits;
	
	public ItemPostVO() {
		super();
	}

	public int getItemPostIndex() {
		return itemPostIndex;
	}

	public void setItemPostIndex(int itemPostIndex) {
		this.itemPostIndex = itemPostIndex;
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

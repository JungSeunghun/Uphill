package com.uphill.web.dto;

import java.util.Date;

public class AskVO {
	private int askIndex;
	private int askGroupIndex;
	private int askGroupLevel;
	private int itemIndex;
	private String userId;
	private Date postDate;
	private String title;
	private String content;
	private String imageFile;
	private int hits;
	
	public AskVO() {
		super();
	}
	
	public AskVO(int itemIndex, String userId, String title, String content,
			String imageFile) {
		super();
		this.itemIndex = itemIndex;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
	}

	public AskVO(int askIndex, int askGroupIndex, int askGroupLevel, int itemIndex, String userId, Date postDate,
			String title, String content, String imageFile, int hits) {
		super();
		this.askIndex = askIndex;
		this.askGroupIndex = askGroupIndex;
		this.askGroupLevel = askGroupLevel;
		this.itemIndex = itemIndex;
		this.userId = userId;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
		this.hits = hits;
	}

	public int getAskIndex() {
		return askIndex;
	}

	public void setAskIndex(int askIndex) {
		this.askIndex = askIndex;
	}

	public int getAskGroupIndex() {
		return askGroupIndex;
	}

	public void setAskGroupIndex(int askGroupIndex) {
		this.askGroupIndex = askGroupIndex;
	}

	public int getAskGroupLevel() {
		return askGroupLevel;
	}

	public void setAskGroupLevel(int askGroupLevel) {
		this.askGroupLevel = askGroupLevel;
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

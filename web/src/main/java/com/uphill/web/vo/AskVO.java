package com.uphill.web.vo;

import java.util.Date;

public class AskVO {
	private int askIndex;
	private int askReplyIndex;
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

	public AskVO(int askIndex, int askReplyIndex, int itemIndex, String userId, Date postDate, String title,
			String content, String imageFile, int hits) {
		super();
		this.askIndex = askIndex;
		this.askReplyIndex = askReplyIndex;
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

	public int getAskReplyIndex() {
		return askReplyIndex;
	}

	public void setAskReplyIndex(int askReplyIndex) {
		this.askReplyIndex = askReplyIndex;
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

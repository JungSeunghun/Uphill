package com.uphill.web.data.ask.dto;

import java.util.Date;

public class AskVO {
	private int askId;
	private int askReplyId;
	private int productPostId;
	private int userId;
	private Date reviewDate;
	private String title;
	private String content;
	private String file;
	private int hits;
	
	public AskVO(int askId, int askReplyId, int productPostId, int userId, Date reviewDate, String title,
			String content, String file, int hits) {
		super();
		this.askId = askId;
		this.askReplyId = askReplyId;
		this.productPostId = productPostId;
		this.userId = userId;
		this.reviewDate = reviewDate;
		this.title = title;
		this.content = content;
		this.file = file;
		this.hits = hits;
	}

	public int getAskId() {
		return askId;
	}

	public void setAskId(int askId) {
		this.askId = askId;
	}

	public int getAskReplyId() {
		return askReplyId;
	}

	public void setAskReplyId(int askReplyId) {
		this.askReplyId = askReplyId;
	}

	public int getProductPostId() {
		return productPostId;
	}

	public void setProductPostId(int productPostId) {
		this.productPostId = productPostId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}

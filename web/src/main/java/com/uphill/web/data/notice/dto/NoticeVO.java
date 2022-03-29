package com.uphill.web.data.notice.dto;

import java.util.Date;

public class NoticeVO {
	private int noticeId;
	private int userId;
	private Date postDate;
	private String title;
	private String content;
	private String imageFile;
	private int hits;
	
	public NoticeVO() {}
	
	public NoticeVO(int noticeId, int userId, Date postDate, String title, String content, String imageFile, int hits) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
		this.hits = hits;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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

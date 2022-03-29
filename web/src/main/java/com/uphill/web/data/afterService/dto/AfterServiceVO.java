package com.uphill.web.data.afterService.dto;

import java.util.Date;

public class AfterServiceVO {
	private int afterServiceId;
	private int userId;
	private Date postDate;
	private String title;
	private String content;
	private String imageFile;
	
	
	public AfterServiceVO(int afterServiceId, int userId, Date postDate, String title, String content,
			String imageFile) {
		super();
		this.afterServiceId = afterServiceId;
		this.userId = userId;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
	}


	public int getAfterServiceId() {
		return afterServiceId;
	}


	public void setAfterServiceId(int afterServiceId) {
		this.afterServiceId = afterServiceId;
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
	
	
}

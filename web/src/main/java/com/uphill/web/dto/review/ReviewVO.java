package com.uphill.web.dto.review;

import java.util.Date;

public class ReviewVO {
	private int reviewIndex;
	private int itemPostIndex;
	private String userId;
	private Date postDate;
	private String title;
	private String content;
	private int starRating;
	private String imageFile;
	private int hits;
	private int recommend;
	
	public ReviewVO() {
		super();
	}

	public int getReviewIndex() {
		return reviewIndex;
	}

	public void setReviewIndex(int reviewIndex) {
		this.reviewIndex = reviewIndex;
	}

	public int getItemPostIndex() {
		return itemPostIndex;
	}

	public void setItemPostIndex(int itemPostIndex) {
		this.itemPostIndex = itemPostIndex;
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

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
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

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
}

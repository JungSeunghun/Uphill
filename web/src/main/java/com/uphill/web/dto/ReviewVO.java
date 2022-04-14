package com.uphill.web.dto;

import java.util.Date;

public class ReviewVO {
	private int reviewIndex;
	private int itemIndex;
	private String userId;
	private Date postDate;
	private String title;
	private String content;
	private float starRating;
	private String imageFile;
	private int hits;
	private int recommend;
	
	public ReviewVO() {
		super();
	}
	
	public ReviewVO(int reviewIndex, int itemIndex, String userId, Date postDate, String title, String content,
			float starRating, String imageFile, int hits, int recommend) {
		super();
		this.reviewIndex = reviewIndex;
		this.itemIndex = itemIndex;
		this.userId = userId;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.starRating = starRating;
		this.imageFile = imageFile;
		this.hits = hits;
		this.recommend = recommend;
	}

	public int getReviewIndex() {
		return reviewIndex;
	}

	public void setReviewIndex(int reviewIndex) {
		this.reviewIndex = reviewIndex;
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

	public float getStarRating() {
		return starRating;
	}

	public void setStarRating(float starRating) {
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

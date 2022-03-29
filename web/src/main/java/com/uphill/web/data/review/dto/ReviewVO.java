package com.uphill.web.data.review.dto;

import java.util.Date;

public class ReviewVO {
	private int reviewId;
	private int productPostId;
	private int userId;
	private Date postDate;
	private int starRating;
	private String title;
	private String content;
	private String imageFile;
	private int hits;
	private int recommend;
	
	public ReviewVO(int reviewId, int productPostId, int userId, Date postDate, int starRating, String title,
			String content, String imageFile, int hits, int recommend) {
		super();
		this.reviewId = reviewId;
		this.productPostId = productPostId;
		this.userId = userId;
		this.postDate = postDate;
		this.starRating = starRating;
		this.title = title;
		this.content = content;
		this.imageFile = imageFile;
		this.hits = hits;
		this.recommend = recommend;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
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

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	
}

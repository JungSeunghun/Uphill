package com.uphill.web.data.review.service;

import java.util.List;

import com.uphill.web.data.review.dto.ReviewVO;

public interface ReviewService {
	List<ReviewVO> getAllReviews();
	ReviewVO getReview(int reviewId);
	boolean registReview(ReviewVO reviewVO);
	boolean updateReview(ReviewVO reviewVO);
	boolean deleteReview(ReviewVO reviewVO);
}

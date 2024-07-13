package com.chatServices.service.Admin;

import java.util.List;

import com.chatServices.entity.Review;

public interface ReviewService {

	String addReviewData(Review review);

	List<Review> getReviews(String id);

}

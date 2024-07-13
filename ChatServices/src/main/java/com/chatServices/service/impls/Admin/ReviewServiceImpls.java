package com.chatServices.service.impls.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Review;
import com.chatServices.entity.repo.ReviewRepository;
import com.chatServices.service.Admin.ReviewService;

@Service
public class ReviewServiceImpls implements ReviewService{
	
	@Autowired
	public ReviewRepository repository;

	@Override
	public String addReviewData(Review review) {
		repository.save(review);
		return "Review posted successfully!";
	}

	@Override
	public List<Review> getReviews(String id) {
		return repository.findByProductId(id);
		
	}

}

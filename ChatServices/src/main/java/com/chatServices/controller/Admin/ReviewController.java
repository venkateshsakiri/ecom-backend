package com.chatServices.controller.Admin;

import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.Review;
import com.chatServices.entity.Users;
import com.chatServices.entity.repo.UsersRepository;
import com.chatServices.responses.ReviewResponse;
import com.chatServices.responses.UpdatedReviewResponse;
import com.chatServices.service.Admin.ReviewService;

@RestController
@RequestMapping("/api/customer")
public class ReviewController {
	
	@Autowired
	public ReviewService reviewService;
	
	@Autowired
	public UsersRepository usersRepository;
	
	@PostMapping("/add-review")
	public ResponseEntity<?> postReview(@RequestBody Review review) throws SQLDataException{
		try {
			String status = reviewService.addReviewData(review);
			return ResponseEntity.ok(status);
		}catch (Exception e) {
			return ResponseEntity.ok(e);
		}
	}
	
	@GetMapping("/reviews/{id}")
	public ResponseEntity<?> getAllReviews(@PathVariable String id){
		try {
			List<Review> reviewList = reviewService.getReviews(id);
			ReviewResponse reviewResponse = new ReviewResponse();
			for(Review review:reviewList) {
				Users user = usersRepository.findByEmail(review.email);
				UpdatedReviewResponse updatedReviewResponse = new UpdatedReviewResponse();
				updatedReviewResponse.description = review.description;
				updatedReviewResponse.ratings = review.rating;
				updatedReviewResponse.userName = user.name;
				reviewResponse.DATA.add(updatedReviewResponse);
				reviewResponse.message = "Reviews fetched successfully!";
				reviewResponse.count = reviewResponse.DATA.size()+"";		
			}
			
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(reviewResponse);
		}catch (Exception e) {
			return ResponseEntity.ok(e);
		}
	}

}

package com.chatServices.responses;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReviewResponse {
	
	public String message;
	
	public String count;
	
	public List<UpdatedReviewResponse> DATA= new ArrayList<>(); 

}

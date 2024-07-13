package com.chatServices.responses;

import java.util.ArrayList;
import java.util.List;

public class OrdersResponse {
	
	public String message;
	
	public String count;
	
	public List<UpdatedOrderResponse> products = new ArrayList<>();

	public List<UpdatedOrderResponse> getProducts() {
		return products;
	}


	public void setProducts(List<UpdatedOrderResponse> products) {
		this.products = products;
	}
	
	

	
	
	
	
}

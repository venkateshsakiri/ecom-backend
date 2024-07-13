package com.chatServices.responses;

import java.util.Optional;

import com.chatServices.entity.AddressList;
import com.chatServices.entity.Product;

public class UpdatedOrderResponse {

	public Optional<Product> product;
	
	public Optional<AddressList> address;
	
	public String price;
	
	public String quantity;
	
	public String status;

	
}

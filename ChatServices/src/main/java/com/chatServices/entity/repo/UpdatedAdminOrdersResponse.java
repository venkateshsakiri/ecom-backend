package com.chatServices.entity.repo;

import java.util.Optional;

import com.chatServices.entity.AddressList;
import com.chatServices.entity.Orders;
import com.chatServices.entity.Product;
import com.chatServices.entity.Users;

import lombok.Data;

@Data
public class UpdatedAdminOrdersResponse {

	public Optional<Product> products;
	
	public Optional<AddressList> address;
	
	public String quantity;
	
	public String price;
	
	public Users user;
	
	public String status;
	
	public Orders order;
}

package com.chatServices.responses;

import java.util.ArrayList;
import java.util.List;

import com.chatServices.entity.Cart;
import com.chatServices.entity.Product;

import lombok.Data;

@Data
public class CartResponse {
	
	private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
	
	public String userName;
	
	public String message;
	
	public String count;
	
	public List<Cart> cartList;

}

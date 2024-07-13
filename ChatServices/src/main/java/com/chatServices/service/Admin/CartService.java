package com.chatServices.service.Admin;

import java.util.List;
import java.util.Optional;

import com.chatServices.entity.Cart;

public interface CartService {

	String addProductsToCart(Cart cart);

	Optional<Cart> getCartItem(Long cartId);
	
	Optional<Cart> getCartItemByProductId(String productId, String userName);
	
	List<Cart> getAllCartItemByEmail(String email);

	String deleteCartItemsById(Long id);
	
	

}

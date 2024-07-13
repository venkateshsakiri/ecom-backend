package com.chatServices.service.impls.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Cart;
import com.chatServices.entity.repo.CartRepository;
import com.chatServices.service.Admin.CartService;

@Service
public class CartServiceImpls implements CartService {
	
	@Autowired
	public CartRepository cartRepository;

	@Override
	public String addProductsToCart(Cart cart) {
		cartRepository.save(cart);
		return "Product added in cart successfully!";
	}

	@Override
	public Optional<Cart> getCartItem(Long cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		if(cart.isPresent()) {
			return cart;
		}
		return null;
	
	}

	@Override
	public Optional<Cart> getCartItemByProductId(String productId, String userName) {
		Optional<Cart> cart = cartRepository.findByProductId(productId,userName);
		if(cart.isPresent()) {
			return cart;
		}
		return Optional.empty();
	}

	@Override
	public List<Cart> getAllCartItemByEmail(String email) {
		List<Cart> cart = cartRepository.findAllCartItemsByUserName(email);
		return cart;
	}

	@Override
	public String deleteCartItemsById(Long id) {
		cartRepository.deleteById(id);
		return "cart Item deleted successfully";
	}

}

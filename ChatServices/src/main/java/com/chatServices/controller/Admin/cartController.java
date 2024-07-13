package com.chatServices.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.Cart;
import com.chatServices.entity.Product;
import com.chatServices.responses.CartResponse;
import com.chatServices.responses.CommonResponse;
import com.chatServices.service.Admin.CartService;
import com.chatServices.service.Admin.ProductService;

@RestController
@RequestMapping("/api/customer")
public class cartController {
	
	@Autowired
	public CartService cartService;
	
	@Autowired
	public ProductService productService;
	
	
	@PostMapping("/addcart")
	public ResponseEntity<?> addToCart(@RequestBody Cart cart){
		try {
			 CommonResponse res = new CommonResponse();
//			Optional<Product> product = productService.getProductById(updatedCartId);
			Optional<Cart> existCart = cartService.getCartItemByProductId(cart.productId,cart.userName);
			if(existCart.isPresent()) {
				res.message = "Product already exists!";
				return ResponseEntity.ok(res);
			}else {
				String status = cartService.addProductsToCart(cart);
				res.message = status;
				return ResponseEntity.ok(res);
			}
			
		}catch (Exception e) {
			return ResponseEntity.ok("Api failure");
		}
		
		
	}
	
	@GetMapping("/cart/{cartId}")
	public Optional<Cart> getCartItemBasedOnId(@PathVariable Long cartId){
		Optional<Cart> cart = cartService.getCartItem(cartId);
		return cart;
	}
	
	@GetMapping("/cart-items/{email}")
	public ResponseEntity<?> getAllcartItems(@PathVariable String email){
		try {
			List<Cart> cartItems = cartService.getAllCartItemByEmail(email);
			CartResponse cartResponse = new CartResponse();
			for(Cart cart:cartItems) {
				Optional<Product> product= productService.getProductById(Long.parseLong(cart.productId));				
				product.ifPresent(prod -> cartResponse.getProducts().add(prod));
			}
			cartResponse.message="All Cart Items Fetched successfully!";
			cartResponse.cartList = cartItems;
			cartResponse.count = Integer.toString(cartResponse.getProducts().size());
			return ResponseEntity.ok(cartResponse);
		}catch (Exception e) {
			ResponseEntity.ok("Api Failure");
		}
		return null;
	}
	
	
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<String> deleteCartItems(@PathVariable Long id){
		String status = cartService.deleteCartItemsById(id);
		return ResponseEntity.ok(status);
	}
	
	

}

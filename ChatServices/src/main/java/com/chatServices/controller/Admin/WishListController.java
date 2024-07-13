package com.chatServices.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.WishList;
import com.chatServices.service.Admin.WishListService;

@RestController
@RequestMapping("/api/")
public class WishListController {
	
	@Autowired
	public WishListService listService;
	
	@PostMapping("/customer/add-fav")
	public ResponseEntity<String> postWishListData(@RequestBody WishList list){
		try {
			String status = listService.postWishList(list);
			return ResponseEntity.ok(status);			
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@GetMapping("/customer/wishlist/{email}")
	public ResponseEntity<?> getAllWhistListBasedOnEmail(@PathVariable String email){
		try {
			List<WishList> list = listService.getAllWishListByEmail(email);
			return ResponseEntity.ok(list);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@DeleteMapping("/customer/wishlist/{id}")
	public ResponseEntity<?> deleteWishList(@PathVariable Long id){
		String status = listService.deleteWishListItemById(id);
		return ResponseEntity.ok(status);
	}
	
	

}

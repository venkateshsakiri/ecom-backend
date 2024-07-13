package com.chatServices.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.AddressList;
import com.chatServices.service.Admin.AddressListService;

@RestController
@RequestMapping("/api/customer")
public class AddressListController {
	
	@Autowired
	public AddressListService addressListService;
	
	
	@PostMapping("/add-address")
	public ResponseEntity<?> addAddress(@RequestBody AddressList address){
		try {
			String status = addressListService.postAddress(address);
			return ResponseEntity.ok(status);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, Please try again");
		}
		
	}
	
	@GetMapping("/address")
	public ResponseEntity<?> getAllAddress(){
		try {
			List<AddressList> addressLi = addressListService.getAddress();
			return ResponseEntity.ok(addressLi);			
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, Please try again");
		}
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable Long id){
		try {
			Optional<AddressList> addressLi = addressListService.getAddressBasedOnId(id);
			if(addressLi.isPresent()) {				
				return ResponseEntity.ok(addressLi);			
			}else {
				return ResponseEntity.ok("Address not found!");
			}
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, Please try again");
		}
	}

}

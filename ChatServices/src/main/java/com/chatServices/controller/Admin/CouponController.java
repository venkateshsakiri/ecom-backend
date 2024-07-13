package com.chatServices.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.Coupons;
import com.chatServices.service.Admin.CouponService;

@RestController
@RequestMapping("/api/admin")
public class CouponController {
	
	@Autowired
	public CouponService couponService;
	
	@PostMapping("/coupon")
	public ResponseEntity<?> addCoupons(@RequestBody Coupons coupons){
		String status = couponService.addCoupon(coupons);
		return ResponseEntity.ok(status);
	}
	
	@GetMapping("/coupon")
	public ResponseEntity<?> getAllCoupons(){
		List<Coupons> listCoupon = couponService.getAllCoupon();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(listCoupon);
	}
	
	@PutMapping("/edit-coupon")
	public ResponseEntity<?> updateCoupon(@RequestBody Coupons coupon){
		Optional<Coupons> listCoupon = couponService.updateCouponById(coupon);
		if(listCoupon.isPresent()) {
			return ResponseEntity.ok(listCoupon);
		}else {
			return ResponseEntity.ok("Coupon id is not found!!");
		}
		
	}
	
	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<?> deleteCoupon(@PathVariable Long id){
		return ResponseEntity.ok(couponService.deleteCouponBy(id));
	}

}

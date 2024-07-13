package com.chatServices.service.impls.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Coupons;
import com.chatServices.entity.repo.CouponRepository;
import com.chatServices.service.Admin.CouponService;

@Service
public class CouponsServiceImpls implements CouponService {
	
	@Autowired
	public CouponRepository couponRepository;

	@Override
	public String addCoupon(Coupons coupons) {
		couponRepository.save(coupons);
		return "Coupon added Successfully!!";
	}

	@Override
	public List<Coupons> getAllCoupon() {
		return couponRepository.findAll();
	}

	@Override
	public Optional<Coupons> updateCouponById(Coupons coupon) {
		if(couponRepository.existsById(coupon.id)) {			
			 couponRepository.save(coupon);
		Optional<Coupons> updatedCoupon = couponRepository.findById(coupon.id);
		return updatedCoupon;
		}
		return null;
		
	}

	@Override
	public String deleteCouponBy(Long id) {
		if(couponRepository.existsById(id)) {
			couponRepository.deleteById(id);
			return "Coupon deleted Successfully!!";
		}
		return "Coupon id is not found!";
	}

}

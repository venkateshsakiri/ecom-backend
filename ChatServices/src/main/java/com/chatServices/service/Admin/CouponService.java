package com.chatServices.service.Admin;

import java.util.List;
import java.util.Optional;

import com.chatServices.entity.Coupons;

public interface CouponService {

	String addCoupon(Coupons coupons);

	List<Coupons> getAllCoupon();

	Optional<Coupons> updateCouponById(Coupons coupon);

	String deleteCouponBy(Long id);

}

package com.chatServices.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Coupons;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, Long>{

}

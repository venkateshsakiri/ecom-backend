package com.chatServices.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.chatServices.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	@Query("SELECT c from Review c Where c.productId = :productId")
	List<Review> findByProductId(String productId);

}

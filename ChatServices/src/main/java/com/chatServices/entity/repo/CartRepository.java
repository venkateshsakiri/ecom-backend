package com.chatServices.entity.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	@Query("SELECT c from Cart c Where c.productId = :productId AND c.userName = :email")
	Optional<Cart> findByProductId(String productId , String email);
	
	@Query("SELECT c from Cart c where c.userName = :email")
	List<Cart> findAllCartItemsByUserName(String email);

}

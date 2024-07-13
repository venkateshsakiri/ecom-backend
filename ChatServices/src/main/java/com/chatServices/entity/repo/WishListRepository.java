package com.chatServices.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.chatServices.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long>{

	@Query("SELECT c from WishList c where c.email = :email")
	List<WishList> findAllOrdersByEmail(String email);
}

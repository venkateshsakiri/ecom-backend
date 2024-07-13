package com.chatServices.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	
	@Query("SELECT c from Orders c where c.email = :email")
	List<Orders> findAllOrdersByEmail(String email);

}

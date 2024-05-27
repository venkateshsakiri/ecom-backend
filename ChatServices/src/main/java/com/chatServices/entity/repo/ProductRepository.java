package com.chatServices.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT m FROM Product m WHERE m.categoryName = :category")
	List<Product> findByProductsByCategoryName(String category); 
}

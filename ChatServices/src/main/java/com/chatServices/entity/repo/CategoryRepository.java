package com.chatServices.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

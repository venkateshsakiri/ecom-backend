package com.chatServices.service.Admin;

import java.util.List;

import com.chatServices.dto.CategoryDto;
import com.chatServices.entity.Category;

public interface CategoryService {

	Category createCategory(CategoryDto categoryDto);
	
	List<Category> getAllCategories();
	
	String deleteCategoryById(Long id);
}

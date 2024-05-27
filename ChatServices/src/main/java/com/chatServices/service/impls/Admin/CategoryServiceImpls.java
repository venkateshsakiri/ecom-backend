package com.chatServices.service.impls.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.dto.CategoryDto;
import com.chatServices.entity.Category;
import com.chatServices.entity.repo.CategoryRepository;
import com.chatServices.service.Admin.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
public class CategoryServiceImpls implements CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;

	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.name = categoryDto.name;
		category.desciption = categoryDto.description;
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public String deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
		return "Category deleted succesfully!";
	}

}

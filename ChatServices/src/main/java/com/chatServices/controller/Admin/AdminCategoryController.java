package com.chatServices.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.dto.CategoryDto;
import com.chatServices.entity.Category;
import com.chatServices.service.Admin.CategoryService;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
		Category category = categoryService.createCategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> allCatergories(){
		List<Category> caterCategories = categoryService.getAllCategories();
		return ResponseEntity.status(HttpStatus.OK).body(caterCategories);
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id){
		String status  = categoryService.deleteCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}

}

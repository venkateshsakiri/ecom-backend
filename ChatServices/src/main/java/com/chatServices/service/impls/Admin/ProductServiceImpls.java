package com.chatServices.service.impls.Admin;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.dto.ProductDto;
import com.chatServices.entity.Category;
import com.chatServices.entity.Product;
import com.chatServices.entity.repo.CategoryRepository;
import com.chatServices.entity.repo.ProductRepository;
import com.chatServices.service.Admin.ProductService;

import ch.qos.logback.core.pattern.parser.Parser;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpls implements ProductService{
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	

	public ProductDto addProducts(ProductDto productDto) throws IOException {
		Product product = new Product();
		Long priceLong = Long.parseLong(productDto.amount);
		product.description = productDto.description;
		product.name = productDto.name;
		product.price =  priceLong;
		product.setImg(productDto.getByteImg());
		product.Amount = productDto.amount;
		product.categoryName = productDto.categoryName;
//		product.img = productDto.img.getBytes();
		System.out.println(productDto);
		Long updatedCategoryId = Long.parseLong(productDto.updatedUategoryId); 
		Category category = categoryRepository.findById(updatedCategoryId).orElseThrow();
		product.category = category;
		return productRepository.save(product).getDto();
		
		
	}
	
	
	public List<Product> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products;
//		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}


	public List<Product> getAllProductsByCategoryName(String category) {
		List<Product> products = productRepository.findByProductsByCategoryName(category);		
		return products;
	}
}

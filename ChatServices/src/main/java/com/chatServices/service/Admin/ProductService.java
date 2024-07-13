package com.chatServices.service.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.chatServices.dto.ProductDto;
import com.chatServices.entity.Product;

public interface ProductService {
	
	ProductDto addProducts(ProductDto productDto) throws IOException;

	List<Product> getAllProducts();
	
	List<Product> getAllProductsByCategoryName(String category);

	Optional<Product> getProductById(Long id);
}

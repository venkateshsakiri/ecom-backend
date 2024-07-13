package com.chatServices.controller.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatServices.dto.ProductDto;
import com.chatServices.entity.Product;
import com.chatServices.service.Admin.ProductService;

@RestController
@RequestMapping("/api/admin")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@Validated @RequestBody ProductDto productDto,BindingResult bindingResult) throws IOException{
		if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid request body");
        }
		ProductDto productDto2 = productService.addProducts(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto2);
		
	}
	
//	@PostMapping("/product")
//	public ResponseEntity<?> addProduct(@RequestParam(value = "categoryId", required = false) String categoryId,
//            @RequestParam("name") String name,
//            @RequestParam("amount") String amount,
//            @RequestParam("description") String description,
//            @RequestPart("img") MultipartFile img,BindingResult bindingResult) throws IOException{
//		System.out.println("Received categoryId: " + categoryId);
//		  if (bindingResult.hasErrors()) {
//	            return ResponseEntity.badRequest().body("Invalid request body");
//	        }
//		  Long categoryIdLong = Long.parseLong(categoryId);
//		ProductDto productDto = new ProductDto();
//	    productDto.setCategoryId((long) 7);
////		productDto.setUpdatedUategoryId(categoryId);
//	    productDto.setName(name);
//	    productDto.setAmount(amount);
//	    productDto.setDescription(description);
//	    productDto.setImg(img);
//		ProductDto productDto2 = productService.addProducts(productDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(productDto2);
//		
//	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String category){
		List<Product> products = productService.getAllProductsByCategoryName(category);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id){
		Optional<Product> product = productService.getProductById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.ok("product not found!!");
	}

}

package com.chatServices.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class ProductDto {

	public Long id;
	
	public String name;
	
	public Long price;
	
	public String amount;
	
	public String categoryName;
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String description;
	
	@JsonProperty("byteImg")
	public byte[] byteImg;
	
	public Long categoryId;
	
	public String updatedUategoryId;
	
	public String getUpdatedUategoryId() {
		return updatedUategoryId;
	}

	public void setUpdatedUategoryId(String updatedUategoryId) {
		this.updatedUategoryId = updatedUategoryId;
	}

	public MultipartFile img;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getByteImg() {
		return byteImg;
	}

	public void setByteImg(byte[] byteImg) {
		this.byteImg = byteImg;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	
	
}

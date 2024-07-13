package com.chatServices.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String productId;
	
	public String addressId;
	
	public String quantity;
	
	public String price;
	
	public String email;
	
	public String status="Placed";
	
//	@Temporal
//	@CreationTimestamp
//	public String timeStamp = Date;

}

package com.chatServices.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.AddressList;
import com.chatServices.entity.Orders;
import com.chatServices.entity.Product;
import com.chatServices.entity.Users;
import com.chatServices.entity.repo.AdminOrdersResponse;
import com.chatServices.entity.repo.UpdatedAdminOrdersResponse;
import com.chatServices.responses.OrdersResponse;
import com.chatServices.responses.UpdatedOrderResponse;
import com.chatServices.service.UserService;
import com.chatServices.service.Admin.AddressListService;
import com.chatServices.service.Admin.OrdersService;
import com.chatServices.service.Admin.ProductService;

@RestController
@RequestMapping("/api")
public class OrdersController {
	
	@Autowired
	public OrdersService ordersService;
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public AddressListService addressService;
	
	@Autowired
	public UserService userService;
	
	@PostMapping("/customer/place-order")
	public ResponseEntity<?> postOrders(@RequestBody Orders order){
		try {
			String status = ordersService.postOrdersIntoDataBase(order);
			return ResponseEntity.ok(status);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@GetMapping("/customer/orders-response/{userId}")
	public ResponseEntity<?> getUpdatedAllOrders(@PathVariable String userId){
		try {
			List<Orders> ordersList = ordersService.findAllOrdersByUserId(userId);	
			OrdersResponse orderResponse = new OrdersResponse();
			for(Orders orders:ordersList) {
				UpdatedOrderResponse updatedRes = new UpdatedOrderResponse();
				Optional<Product> product= productService.getProductById(Long.parseLong(orders.productId));
				Optional<AddressList> addressRes = addressService.getAddressBasedOnId(Long.parseLong(orders.addressId));
				
				if(product.isPresent() && addressRes.isPresent()) {
//					OrdersResponse orderResponse = new OrdersResponse();
					updatedRes.product = product;
					updatedRes.address = addressRes;
					updatedRes.price = orders.price;
					updatedRes.quantity = orders.quantity;
					updatedRes.status = orders.status;					
//					orderResponse.products.add(updatedRes);
					orderResponse.getProducts().add(updatedRes);
					orderResponse.message = "Orders fetched successfully!!";
					orderResponse.count = orderResponse.products.size()+"";
				}
				
			}
			
			return ResponseEntity.ok(orderResponse);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@GetMapping("/customer/orders/{email}")
	public ResponseEntity<?> getAllOrders(@PathVariable String email){
		try {
			List<Orders> ordersList = ordersService.findAllOrdersByUserId(email);
			return ResponseEntity.ok(ordersList);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@GetMapping("/admin/orders")
	public ResponseEntity<?> getAllOrdersForAdmin(){
		try {
			List<Orders> orderList = ordersService.findAllOrders();			
			AdminOrdersResponse orderResponse = new AdminOrdersResponse();
			for(Orders order:orderList) {
				UpdatedAdminOrdersResponse updatedOrderResponse = new UpdatedAdminOrdersResponse();
				Optional<Product> product= productService.getProductById(Long.parseLong(order.productId));
				Optional<AddressList> addressRes = addressService.getAddressBasedOnId(Long.parseLong(order.addressId));
				Users user = userService.existCreateUser(order.email);	
				if(product.isPresent() && addressRes.isPresent()) {
					updatedOrderResponse.address = addressRes;
					updatedOrderResponse.products = product;
					updatedOrderResponse.price = order.price;
					updatedOrderResponse.status = order.status;
					updatedOrderResponse.quantity = order.quantity;
					updatedOrderResponse.user = user;
					updatedOrderResponse.order = order;
					orderResponse.DATA.add(updatedOrderResponse);
					orderResponse.count = orderResponse.DATA.size()+"";
					orderResponse.message = "Orders fetched successfully";
				}
			}
			
			return ResponseEntity.ok(orderResponse);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}
	
	@PutMapping("/admin/orders")
	public ResponseEntity<?> updateOrderStatus(@RequestBody Orders order){
		try {
			String status = ordersService.updateStatuById(order);
			return ResponseEntity.ok(status);
		}catch (Exception e) {
			return ResponseEntity.ok("System error occured, please try again");
		}
	}

}

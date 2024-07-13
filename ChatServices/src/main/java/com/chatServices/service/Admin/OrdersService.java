package com.chatServices.service.Admin;

import java.util.List;

import com.chatServices.entity.Orders;

public interface OrdersService {

	String postOrdersIntoDataBase(Orders order);

	List<Orders> findAllOrdersByUserId(String userId);
	
	List<Orders> findAllOrders();

	String updateStatuById(Orders order);

}

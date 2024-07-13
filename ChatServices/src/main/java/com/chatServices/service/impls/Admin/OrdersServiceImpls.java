package com.chatServices.service.impls.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Orders;
import com.chatServices.entity.repo.OrdersRepository;
import com.chatServices.service.Admin.OrdersService;

@Service
public class OrdersServiceImpls implements OrdersService {
	
	@Autowired
	public OrdersRepository ordersRepository;

	@Override
	public String postOrdersIntoDataBase(Orders order) {
			ordersRepository.save(order);
		return "Your Order placed successfully!!";
	}

	@Override
    public List<Orders> findAllOrdersByUserId(String userId) {
        return ordersRepository.findAllOrdersByEmail(userId);
    }

	@Override
	public List<Orders> findAllOrders() {
		return ordersRepository.findAll();
	}

	@Override
	public String updateStatuById(Orders order) {
		if(ordersRepository.existsById(order.id)) {
			ordersRepository.save(order);
			return "Order status updated Successfully!";
		}
		return null;
	}

}

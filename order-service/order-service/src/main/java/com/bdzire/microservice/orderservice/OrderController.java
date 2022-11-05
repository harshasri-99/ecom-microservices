package com.bdzire.microservice.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderDAOService service;
	
	@GetMapping("/{orderId}")
	public Order get(@PathVariable int orderId) {
		return service.findByOrderId(orderId);
	}
	
	@PostMapping("/{userId}/{productId}/{qty}")
	public Order create(@PathVariable int userId, @PathVariable int productId, @PathVariable int qty) {
		return service.placeOrder(userId, productId, qty);
	}
	
	@DeleteMapping("/{orderId}")
	public void delete(@PathVariable int orderId) {
		service.cancelOrder(orderId);
		service.deleteByOrderId(orderId);
	}
}

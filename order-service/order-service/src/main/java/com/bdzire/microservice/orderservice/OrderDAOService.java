package com.bdzire.microservice.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDAOService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserProxy userProxy;
	
	@Autowired
	ProductProxy productProxy;
	
	@Autowired
	OrderConfiguration orderConfiguration;
	
	public Order findByOrderId(int orderId) {
		return orderRepository.findById(orderId).get();
	}
	
	public Order placeOrder(int userId, int productId, int quantity) {
		Order order1 = userProxy.retriveUser(userId);
		Order order2 = productProxy.get(productId);
		
		if(quantity > order2.getQuantity())
			throw new QuantityNotAvailableException("Quantity not available please reduce quantity");
		
		productProxy.decreaseQuantity(productId, quantity);
		Order newOrder = new Order(order1, order2);
		newOrder.setQuantity(quantity);
		newOrder.setTotalPrice(quantity*order2.getPrice());
		
		if(quantity > orderConfiguration.getMaxquantity() || newOrder.getTotalPrice() > orderConfiguration.getMaxtotal()) {
			throw new MaxOrderLimitException("Order quantity or total price limit exceeded");
		}
		
		orderRepository.save(newOrder);
		return newOrder;
	}
	
	public void cancelOrder(int orderId) {
		Order order = orderRepository.findByOrderId(orderId);
		productProxy.increaseQuantity(order.getProductId(), order.getQuantity());
	}

	public void deleteByOrderId(int orderId) {
		orderRepository.deleteByOrderId(orderId);
	}
}

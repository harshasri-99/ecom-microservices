package com.bdzire.microservice.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

	Order findByOrderId(int orderId);

	void deleteByOrderId(int orderId);
	
}

package com.bdzire.microservice.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="product-service")
public interface ProductProxy {

	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public Order get(@PathVariable Integer id);
	
	@RequestMapping(value="/products/{id}/{qty}/increase", method=RequestMethod.PUT)
	public Order increaseQuantity(@PathVariable Integer id,@PathVariable Integer qty);
	
	@RequestMapping(value="/products/{id}/{qty}/decrease", method=RequestMethod.PUT)
	public Order decreaseQuantity(@PathVariable Integer id,@PathVariable Integer qty);
}

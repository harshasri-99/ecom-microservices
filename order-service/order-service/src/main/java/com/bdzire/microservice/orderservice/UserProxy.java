package com.bdzire.microservice.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface UserProxy {

	@GetMapping("/users/{id}")
	public Order retriveUser(@PathVariable Integer id);
	
}

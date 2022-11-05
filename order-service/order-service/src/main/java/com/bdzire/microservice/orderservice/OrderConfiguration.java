package com.bdzire.microservice.orderservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("order-service")
public class OrderConfiguration {

	private int maxquantity;
	private int maxtotal;
	
	public int getMaxquantity() {
		return maxquantity;
	}
	public void setMaxquantity(int maxquantity) {
		this.maxquantity = maxquantity;
	}
	public int getMaxtotal() {
		return maxtotal;
	}
	public void setMaxtotal(int maxtotal) {
		this.maxtotal = maxtotal;
	}
}

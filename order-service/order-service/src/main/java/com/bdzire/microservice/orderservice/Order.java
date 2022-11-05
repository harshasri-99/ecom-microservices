package com.bdzire.microservice.orderservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="order_details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "user_id")
	@JsonIgnore
	private int userId;
	private String name;
	@Column(name = "phone_no")
	private String phoneNo;
	private String address;
	@Column(name = "product_id")
	@JsonIgnore
	private int productId;
	@Column(name = "product_name")
	private String productName;
	private int price;
	private int quantity;
	private int totalPrice;
	
	public Order() {
	}
	
	public Order(Order order1, Order order2) {
		super();
		this.orderDate = new Date();
		this.userId = order1.getUserId();
		this.name = order1.getName();
		this.phoneNo = order1.getPhoneNo();
		this.address = order1.getAddress();
		this.productId = order2.getProductId();
		this.productName = order2.getProductName();
		this.price = order2.price;
	}
		
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

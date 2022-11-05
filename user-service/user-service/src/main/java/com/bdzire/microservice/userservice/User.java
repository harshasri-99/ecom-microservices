package com.bdzire.microservice.userservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer userId;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@Column(name = "phone_no")
	@Size(min=5, message = "enter valid phone no")
	private String phoneNo;
	
	private String address;
	
	public User() {}
	
	public User(Integer userId, String name, String phoneNo, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
	
}

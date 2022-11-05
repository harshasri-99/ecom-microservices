package com.bdzire.microservice.userservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findOne(Integer id) {
		return repository.findById(id).get();
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}

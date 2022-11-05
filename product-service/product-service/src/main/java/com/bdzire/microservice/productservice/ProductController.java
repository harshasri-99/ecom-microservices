package com.bdzire.microservice.productservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> list(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable Integer id) {
		return productRepository.findById(id).get();
	}
	
	@PostMapping
	public Product create(@RequestBody final Product product) {
		return productRepository.save(product); 
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable Integer id) {
		productRepository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}/{qty}/increase", method=RequestMethod.PUT)
	public Product increaseQuantity(@PathVariable Integer id,@PathVariable Integer qty) {
		Product existingProduct = productRepository.findById(id).get();
		existingProduct.setQuantity(existingProduct.getQuantity() + qty);
		return productRepository.save(existingProduct);
	}
	
	@RequestMapping(value="/{id}/{qty}/decrease", method=RequestMethod.PUT)
	public Product decreaseQuantity(@PathVariable Integer id,@PathVariable Integer qty) {
		Product existingProduct = productRepository.findById(id).get();
		existingProduct.setQuantity(existingProduct.getQuantity() - qty);
		return productRepository.save(existingProduct);
	}
}

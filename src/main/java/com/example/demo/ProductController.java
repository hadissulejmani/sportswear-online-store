package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

@RestController
public class ProductController {

	@Autowired
	ProductService productsList;
	
	@RequestMapping("/products")
	public List<Product> getProductsList() {
		return productsList.getProducts();
	}
	
	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable long id) {
		return productsList.getSingleProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products/add")
	public void addProduct(@RequestBody Product product) {
		productsList.addProduct(product);
	}
}

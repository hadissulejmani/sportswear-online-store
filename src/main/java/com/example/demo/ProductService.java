package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

@Service
public class ProductService {

	private List<Product> productList = new ArrayList<Product>(
				Arrays.asList(
						new Product(1, "Bruno", "Kurxho hic", "", new Category(1, "MAICA"), new Manufacturer(1, "NIKE")),
						new Product(2, "Mars", "Kurxho hic", "", new Category(1, "MAICA"), new Manufacturer(1, "NIKE")),
						new Product(3, "Jamaica", "Kurxho hic", "", new Category(1, "MAICA"), new Manufacturer(1, "NIKE")),
						new Product(4, "Russian Bear", "Kurxho hic", "", new Category(2, "Bluza"), new Manufacturer(1, "NIKE")),
						new Product(5, "Brocculi", "Kurxho hic", "", new Category(2, "Bluza"), new Manufacturer(1, "NIKE")),
						new Product(6, "Miami", "Kurxho hic", "", new Category(2, "Bluza"), new Manufacturer(1, "NIKE")),
						new Product(7, "Selenica", "Kurxho hic", "", new Category(2, "Bluza"), new Manufacturer(1, "NIKE")),
						new Product(8, "Sephora", "Kurxho hic", "", new Category(3, "Shorca"), new Manufacturer(2, "Adidas")),
						new Product(9, "Zambac", "Kurxho hic", "", new Category(3, "Shorca"), new Manufacturer(4, "Pull&Bear"))
				)
			);

	public List<Product> getProducts() {
		return productList;
	}
	
	public Product getSingleProduct(long id) {
		return productList.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}
	
	
}

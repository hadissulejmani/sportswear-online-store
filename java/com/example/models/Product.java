package com.example.models;

public class Product {

	Long id;
	String name;
	String content;
	String url;
	Category category;
	Manufacturer manufacturer;


	public Product() {
		
	}
	
	public Product(Long id, String name, String content, String url, Category category, Manufacturer manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.url = url;
		this.category = category;
		this.manufacturer = manufacturer;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
}

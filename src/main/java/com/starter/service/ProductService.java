package com.starter.service;

import java.util.List;

import com.starter.model.Product;

public interface ProductService {

	public Integer saveProduct(Product p);
	public List<Product> getAllProducts();
	public void deleteProduct(Integer id);
	public Product getProduct(Integer id);
}

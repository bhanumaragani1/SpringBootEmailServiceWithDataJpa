package com.starter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.model.Product;
import com.starter.repo.ProductRepository;

@Service
public class ProductServiceImpl 
		implements ProductService {
	
	@Autowired
	private ProductRepository repo;

	@Transactional
	public Integer saveProduct(Product p) {
		//calculations here..
		//gstAmt= cost*gst/100
		//totalAmt=cost+ gstAmt - disc
		p=repo.save(p);
		return p.getId();
	}
	
	
	@Transactional
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	@Transactional
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
	
	@Transactional
	public Product getProduct(Integer id) {
		Optional<Product> op = repo.findById(id);
		Product p = op.get();
		return p;
	}
	
}

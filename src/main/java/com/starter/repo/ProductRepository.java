package com.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

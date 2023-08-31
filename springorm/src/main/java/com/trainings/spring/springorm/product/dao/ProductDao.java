package com.trainings.spring.springorm.product.dao;

import java.util.List;

import com.trainings.spring.springorm.product.entity.ProductEntity;

public interface ProductDao {
	int create(ProductEntity product);
	
	void update(ProductEntity product);
	
	void delete(ProductEntity product);
	
	ProductEntity find(int id);
	
	List<ProductEntity> findAll();
}

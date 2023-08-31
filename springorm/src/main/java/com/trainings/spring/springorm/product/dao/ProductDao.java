package com.trainings.spring.springorm.product.dao;

import com.trainings.spring.springorm.product.entity.ProductEntity;

public interface ProductDao {
	int create(ProductEntity product);
}

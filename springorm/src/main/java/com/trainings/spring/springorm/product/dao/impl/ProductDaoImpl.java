package com.trainings.spring.springorm.product.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trainings.spring.springorm.product.dao.ProductDao;
import com.trainings.spring.springorm.product.entity.ProductEntity;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional
	public int create(ProductEntity product) {
		Integer result = (Integer) hibernateTemplate.save(product);
		return result;
	}

	@Override
	@Transactional
	public void update(ProductEntity product) {
		hibernateTemplate.update(product);
	}

	@Override
	@Transactional
	public void delete(ProductEntity product) {
		hibernateTemplate.delete(product);
	}

	@Override
	public ProductEntity find(int id) {
		ProductEntity product = hibernateTemplate.get(ProductEntity.class, id);
		return product;
	}

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> productList = hibernateTemplate.loadAll(ProductEntity.class);
		return productList;
	}

}

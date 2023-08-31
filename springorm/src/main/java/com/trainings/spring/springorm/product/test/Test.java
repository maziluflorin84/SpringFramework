package com.trainings.spring.springorm.product.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trainings.spring.springorm.product.dao.ProductDao;
import com.trainings.spring.springorm.product.entity.ProductEntity;

public class Test {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("com/trainings/spring/springorm/product/test/config.xml");
		ProductDao productDao = (ProductDao) context.getBean("productDao");
//		ProductEntity product = new ProductEntity();
//		product.setId(2);
//		product.setName("iPhone");
//		product.setDesc("Pro");
//		product.setPrice(6000);
//		productDao.create(product);
//		productDao.update(product);
//		productDao.delete(product);
		
//		ProductEntity product = productDao.find(1);
//		System.out.println(product);
		
		List<ProductEntity> productList = productDao.findAll();
		System.out.println(productList);
	}

}

package com.trainings.spring.springorm.product.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trainings.spring.springorm.product.dao.ProductDao;
import com.trainings.spring.springorm.product.entity.ProductEntity;

public class Test {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("com/trainings/spring/springorm/product/test/config.xml");
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		ProductEntity product = new ProductEntity();
		product.setId(1);
		product.setName("iPhone");
		product.setDesc("Coooooool");
		product.setPrice(4000);
		productDao.create(product);
	}

}

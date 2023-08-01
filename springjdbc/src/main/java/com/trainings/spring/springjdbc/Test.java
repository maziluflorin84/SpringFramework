package com.trainings.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("com/trainings/spring/springjdbc/config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		String sql = "insert into employee values (?,?,?)";
		int result = jdbcTemplate.update(sql, 1, "Florin", "Mazilu");
		if (result == 1) {
			System.out.println("Record inserted!!!");
		} else {
			System.out.println("Something went wrong!");
		}
	}

}

package com.trainings.spring.springjdbc.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trainings.spring.springjdbc.employee.dao.EmployeeDao;
import com.trainings.spring.springjdbc.employee.dto.Employee;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("com/trainings/spring/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setId(2);
		employee.setFirstName("John");
		employee.setLastName("Doe");
		int result = dao.create(employee);
		if (result == 1) {
			System.out.println("Record inserted!!!");
		} else {
			System.out.println("Something went wrong!");
		}
	}
}

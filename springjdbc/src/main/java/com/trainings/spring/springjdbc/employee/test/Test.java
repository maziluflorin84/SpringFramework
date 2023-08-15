package com.trainings.spring.springjdbc.employee.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trainings.spring.springjdbc.employee.dao.EmployeeDao;
import com.trainings.spring.springjdbc.employee.dto.Employee;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("com/trainings/spring/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setId(2);
		int result = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter:\n1 to add John Doe\n2 to rename John Doe\n3 to delete someone");
			int input = scanner.nextInt();
			if (input == 1) {
				employee.setFirstName("John");
				employee.setLastName("Doe");
				result = dao.create(employee);
				if (result == 1)
					System.out.println("Record inserted!!!");
			} else if (input == 2) {
				employee.setFirstName("Johny");
				employee.setLastName("Does");
				result = dao.update(employee);
				if (result == 1)
					System.out.println("Record modified!!!");
			} else if (input == 3) {
				List<Employee> list = dao.readList();
				System.out.println("Select an id from the list bellow\n");
				System.out.println("Id\tFirst Name\tLast Name");
				for (Employee item : list) {
					System.out.println(item.getId() + "\t" + item.getFirstName() + "\t\t" + item.getLastName());
				}
				input = scanner.nextInt();
				result = dao.delete(input);
				if (result == 1) {
					for (Employee item : list) {
						if (item.getId() == input) {
							System.out.println(item.getFirstName() + " was deleted!!!");
						}
					}
				}
			}
			if (result != 1) {
				System.out.println("Something went wrong");
			}
		} 
	}
}

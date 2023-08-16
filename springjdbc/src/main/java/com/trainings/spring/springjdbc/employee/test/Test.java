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
		int result = 0;
		String message = "";

		try (Scanner scanner = new Scanner(System.in)) {

			List<Employee> empList = dao.readList();
			printList(empList, false);
			
			System.out.println(
					"Enter:\n1 to add John Doe\n2 to update employee\n3 to delete someone");
			int selectAction = scanner.nextInt();
			switch (selectAction) {
			case 1:
				employee.setId(dao.readMaxId() + 1);
				employee.setFirstName("John");
				employee.setLastName("Doe");
				result = dao.create(employee);
				message = "added";
				break;
			case 2:
				System.out.println("Select an id to update");
				employee.setId(scanner.nextInt());
				System.out.println("Give a first name");
				employee.setFirstName(scanner.next());
				System.out.println("Give a last name");
				employee.setLastName(scanner.next());
				result = dao.update(employee);
				message = "updated";
				break;
			case 3:
				System.out.println("Select an id to delete");
				result = dao.delete(scanner.nextInt());
				message = "deleted";
				break;
			default:
				break;
			}
			if (result == 1) {
				System.out.println("Record was " + message + "!!!");
				empList = dao.readList();
				printList(empList, true);
			} else if (result == 0) {
				System.out.println("Something went wrong");
			}
		}
	}

	private static void printList(List<Employee> empList, boolean updated) {
		System.out.println("The" + (updated ? " updated " : " ") + "list:");
		System.out.println("Id\tFirst Name\tLast Name");
		for (Employee item : empList) {
			System.out.println(item.getId() + "\t" + item.getFirstName() + "\t\t" + item.getLastName());
		}
		System.out.println();
	}
}

package com.trainings.spring.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trainings.spring.springmvc.dto.Employee;

@Controller
public class ListController {

	@RequestMapping("/readList")
	public ModelAndView sendList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayList");
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("Florin");
		employee1.setSalary(5000);
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Miruna");
		employee2.setSalary(6000);
		
		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setName("Cosmin");
		employee3.setSalary(5000);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		
		modelAndView.addObject("list", list);
		
		return modelAndView;
	}
}

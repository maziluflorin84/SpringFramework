package com.trainings.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trainings.spring.springmvc.dto.User;

@Controller
public class UserController {
	@RequestMapping("registrationPage")
	public ModelAndView showRegistrationPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userReg");
		return modelAndView;
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("regResult");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
}

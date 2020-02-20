package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.autoconfigure.WelcomeService;
import com.sai.beans.WelcomeBean;

@RestController
public class GreetingController {

	@Autowired
	//@Qualifier("myWelcomeServiceImpl")
	WelcomeService welcomeService;
	
	@Autowired
	WelcomeBean welcomeBean;
	
	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("Name...."+welcomeBean.getName());
		return welcomeService.sayHello();
	}
	
}

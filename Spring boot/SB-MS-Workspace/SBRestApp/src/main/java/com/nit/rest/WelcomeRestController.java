package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/welcome")
public class WelcomeRestController {

	public WelcomeRestController() {
		System.out.println("WelcomeRestController::Constructor");
	}

	@GetMapping
	public String welcomeMsg() {
		String msg = "<h1>Welcome to Restful Services....!!</h1>";
		return msg;
	}
}

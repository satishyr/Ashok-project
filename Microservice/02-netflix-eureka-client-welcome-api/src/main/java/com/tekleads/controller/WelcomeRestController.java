package com.tekleads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tekleads.feign.GreetServiceProxyClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetServiceProxyClient greetClient;

	@GetMapping("/getWelcomeMsg/{name}")
	public String welcomeMsg(@PathVariable("name") String name) {

		//Making a REST Call
		String greetMsg = greetClient.invokeGreetMsg(name);

		String welcomeMsg = "Welcome to MicroServices...!!";

		return greetMsg + " --- " + welcomeMsg;
	}
}

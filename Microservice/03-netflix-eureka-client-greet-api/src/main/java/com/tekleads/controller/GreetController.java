package com.tekleads.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/getGreetMsg/{name}")
	public String greetMsg(@PathVariable("name") String name) {
		return name+", Good Morning...!!";
	}

}

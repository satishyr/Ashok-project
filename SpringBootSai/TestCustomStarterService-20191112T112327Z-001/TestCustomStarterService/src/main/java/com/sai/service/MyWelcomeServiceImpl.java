package com.sai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.autoconfigure.WelcomeService;
import com.sai.beans.WelcomeBean;

@Service
public class MyWelcomeServiceImpl implements WelcomeService{
	
	@Autowired
	WelcomeBean welcomeBean;

	@Override
	public String sayHello() {
		return "Welcome, "+welcomeBean.getName();
	}

}

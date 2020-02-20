package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sai.autoconfigure.WelcomeServiceAutoConfiguration;
import com.sai.beans.WelcomeBean;

@SpringBootApplication
public class TestCustomStarterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCustomStarterServiceApplication.class, args);
	}
	
//	@Bean
//	public WelcomeBean welcomeBean() {
//		WelcomeBean welcomeBean=new WelcomeBean();
//		welcomeBean.setName("Sai");
//		System.out.println("In myWelcomeBean()........!");
//		return welcomeBean;
//	}

}

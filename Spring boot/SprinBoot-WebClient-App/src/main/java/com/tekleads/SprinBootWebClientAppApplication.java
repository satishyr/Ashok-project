package com.tekleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tekleads.service.CustomerService;

@SpringBootApplication
public class SprinBootWebClientAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SprinBootWebClientAppApplication.class, args);

		CustomerService csBean = ctxt.getBean(CustomerService.class);

		csBean.fetchCustomerByEmailSync("ashok@gmail.com");
		System.out.println("=========================================================================");
		csBean.fetchCustomerByEmailAsync("ashok@gmail.com");
	}

}

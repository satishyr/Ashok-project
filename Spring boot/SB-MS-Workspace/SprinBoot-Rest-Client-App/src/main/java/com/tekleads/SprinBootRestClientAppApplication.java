package com.tekleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tekleads.service.CustomerRestClient;

@SpringBootApplication
public class SprinBootRestClientAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SprinBootRestClientAppApplication.class, args);

		CustomerRestClient customerRestClient = ctxt.getBean(CustomerRestClient.class);

		// customerRestClient.invokeCustomerUsingEmail("ashok@gmail.com");
		// customerRestClient.invokeAllCustomersEmails();
		// customerRestClient.invokeCustomerById(40983);
		customerRestClient.addCustomer();
	}
}

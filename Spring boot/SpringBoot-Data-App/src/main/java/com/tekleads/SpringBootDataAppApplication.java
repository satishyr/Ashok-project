package com.tekleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tekleads.service.ContactService;

@SpringBootApplication
public class SpringBootDataAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootDataAppApplication.class,
				args);

		ContactService contactService = applicationContext.getBean(ContactService.class);

		// contactService.saveContactDetails();
		// contactService.findContactById(401);
		//contactService.findAllContactDtls();
		//contactService.finalAllEmails();
		contactService.findCustomerByEmail("John.p@gmail.com");
	}

}

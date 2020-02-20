package com.tekleads.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tekleads.bindings.Customer;

@Service
public class CustomerService {

	private static final String GET_CUSTOMER_BY_EMAIL_URL = "http://localhost:9090/getByEmail?email=";

	public void fetchCustomerByEmailSync(String email) {
		WebClient.Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		System.out.println("****Before Rest Call*****");
		Customer customer = webClient.get()
				 		     		 .uri(GET_CUSTOMER_BY_EMAIL_URL+email)
				 		     		 .retrieve()
				 		     		 .bodyToMono(Customer.class)
				 		     		 .block();
		System.out.println(customer);
		System.out.println("*****After Rest Call******");
	}
	
	public void fetchCustomerByEmailAsync(String email) {
		WebClient.Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		System.out.println("****Before Rest Call*****");
		
		webClient.get()
	     		 .uri(GET_CUSTOMER_BY_EMAIL_URL+email)
	     		 .retrieve()
	     		 .bodyToMono(Customer.class)
	     		 .subscribe(CustomerService::doWorkWithCustomerObj);
							
		System.out.println("*****After Rest Call******");
		//logic
	}

	public static void doWorkWithCustomerObj(Customer c) {
		System.out.println(c);
	}
	
}

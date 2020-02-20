package com.tekleads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tekleads.bindings.Customer;

@Service
public class CustomerRestClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_CUSTOMER_BY_EMAIL_URL = "http://localhost:9090/getByEmail?email=";

	private static final String GET_ALL_EMAILS_URL = "http://localhost:9090/getAllEmails";

	private static final String GET_CUSTOMER_BY_ID = "http://localhost:9090/get/{id}";

	private static final String ADD_CUSTOMER_URL = "http://localhost:9090/add";

	public void invokeCustomerUsingEmail(String email) {
		// ResponseEntity<String> resEntity =
		// restTemplate.getForEntity(GET_CUSTOMER_BY_EMAIL_URL + email, String.class);
		ResponseEntity<Customer> resEntity = restTemplate.getForEntity(GET_CUSTOMER_BY_EMAIL_URL + email,
				Customer.class);
		int statusCd = resEntity.getStatusCode().value();
		if (statusCd == 200) {
			Customer c = resEntity.getBody();
			System.out.println(c);
		}
	}

	public void invokeAllCustomersEmails() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_ALL_EMAILS_URL, String.class);
		int statusCode = responseEntity.getStatusCode().value();
		if (statusCode == 200) {
			String body = responseEntity.getBody();
			System.out.println(body);
		}
	}

	public void invokeCustomerById(Integer cid) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(GET_CUSTOMER_BY_ID, String.class, cid);
		int statusCode = responseEntity.getStatusCode().value();
		if (statusCode == 200) {
			String body = responseEntity.getBody();
			System.out.println(body);
		}
	}

	public void addCustomer() {
		Customer c = new Customer();
		c.setCustomerEmail("orlen@gmail.com");
		c.setCustomerName("Orlen");

		ResponseEntity<String> postForEntity = restTemplate.postForEntity(ADD_CUSTOMER_URL, c, String.class);

		System.out.println("hi");
		
		int statusCode = postForEntity.getStatusCode().value();
		if (statusCode == 201) {
			String body = postForEntity.getBody();
			System.out.println(body);
		}
	}
}

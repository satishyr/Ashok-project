package com.nit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.domain.Customer;
import com.nit.entity.CustomerEntity;
import com.nit.repositories.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepo;

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Test
	public void saveCustomerTestPositive() {
		CustomerEntity entity = new CustomerEntity();// a
		entity.setCustomerId(101);

		Mockito.when(customerRepo.save(Mockito.any(CustomerEntity.class))).thenReturn(entity);

		Customer c = new Customer();
		c.setCustomerId(101);

		boolean isSaved = customerService.saveCustomer(c);
		assertTrue(isSaved);
	}
	
	@Test
	public void saveCustomerTestNegative() {
		Mockito.when(customerRepo.save(Mockito.any(CustomerEntity.class))).thenReturn(null);
		Customer c = new Customer();
		c.setCustomerId(101);
		boolean isSaved = customerService.saveCustomer(c);
		assertFalse(isSaved);
	}

	@Test
	public void findAllEmailsTest() {
		List<String> emails = new ArrayList<String>();
		emails.add("test1@gmail.com");
		emails.add("test2@gmail.com");

		when(customerRepo.findAllEmails()).thenReturn(emails);

		List<String> actualEmails = customerService.findAllEmails();
		assertEquals(emails.size(), actualEmails.size());
	}

	@Test
	public void findCustomerByEmailTestPositive() {
		String testMail = "test@gmail.com";

		CustomerEntity entity = new CustomerEntity();
		entity.setCustomerEmail(testMail);
		entity.setCustomerId(101);
		entity.setCustomerName("test_name");

		when(customerRepo.findByCustomerEmail(testMail)).thenReturn(entity);

		Customer c = customerService.findCustomerByEmail(testMail);
		assertNotNull(c);
	}

	@Test
	public void findCustomerByEmailTestNegative() {
		String testMail = "test1@gmail.com";
		when(customerRepo.findByCustomerEmail(testMail)).thenReturn(null);
		Customer c = customerService.findCustomerByEmail(testMail);
		assertNull(c);
	}

	@Test
	public void getCustomerByIdTestPositive() {
		CustomerEntity entity = new CustomerEntity();
		entity.setCustomerId(101);
		entity.setCustomerName("John");
		entity.setCustomerEmail("john@gmail.com");

		Optional<CustomerEntity> optionalObj = Optional.of(entity);

		when(customerRepo.findById(101)).thenReturn(optionalObj);

		Customer customer = customerService.getCustomerById(101);
		assertNotNull(customer);
	}

	@Test
	public void getCustomerByIdTestNegative() {
		when(customerRepo.findById(102)).thenReturn(null);
		Customer customer = customerService.getCustomerById(101);
		assertNull(customer);
	}

}

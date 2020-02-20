/*package com.nit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nit.domain.Customer;
import com.nit.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerRestController.class)
public class CustomerRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void getAllCustomersEmailsTest() throws Exception {
		List<String> emails = new ArrayList<String>();
		emails.add("test1@gmail.com");
		emails.add("test2@gmail.com");

		when(customerService.findAllEmails()).thenReturn(emails);

		// create RequestBuilder object
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllEmails");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int status = result.getResponse().getStatus();

		assertEquals(200, status);
	}

	@Test
	public void getCustomerByEmailTest() throws Exception {
		Customer c = new Customer();
		c.setCustomerId(101);

		when(customerService.findCustomerByEmail("test@gmail.com")).thenReturn(c);

		RequestBuilder builder = MockMvcRequestBuilders.get("/getByEmail?email=test@gmail.com");

		MvcResult result = mockMvc.perform(builder).andReturn();

		int status = result.getResponse().getStatus();

		assertEquals(200, status);
	}

	@Test
	public void getCustomerByIdTestPositive() throws Exception {
		Customer c = new Customer();
		c.setCustomerId(101);
		c.setCustomerName("John");
		c.setCustomerEmail("john@gmail.com");

		when(customerService.getCustomerById(101)).thenReturn(c);

		RequestBuilder builder = MockMvcRequestBuilders.get("/get/101");

		MvcResult result = mockMvc.perform(builder).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void getCustomerByIdTestNegative() throws Exception {

		when(customerService.getCustomerById(101)).thenReturn(null);

		RequestBuilder builder = MockMvcRequestBuilders.get("/get/101");

		MvcResult result = mockMvc.perform(builder).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(400, status);
	}

}
*/
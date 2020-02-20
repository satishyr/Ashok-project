package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.nit.domain.Customer;
import com.nit.domain.CustomerEvent;
import com.nit.exceptions.CustomerNotFoundException;
import com.nit.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "This API is used to deal with Customers Details")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@ApiResponses({ @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Server Problem") })
	@ApiOperation(value = "This Operations is used to provide Customer Details Based on Customer ID")
	@GetMapping(value = "/get/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Customer> getCustomer(
			@ApiParam(required = true, value = "This represents Customer Id") @PathVariable("id") Integer cid) {
		Customer c = customerService.getCustomerById(cid);
		if (c == null) {
			throw new CustomerNotFoundException();
		}
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}

	@ApiOperation(value = "This operation is used to save customer details")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Server Problem") })
	@PostMapping(value = "/add", consumes = { "application/json", "application/xml" })
	public ResponseEntity<String> addCustomer(
			@ApiParam(value = "This represents Customer Data") @RequestBody Customer c) {
		boolean isSaved = customerService.saveCustomer(c);
		if (isSaved) {
			String msg = "Customer Added Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		String msg = "Failed to add, Duplicate Customer..!!";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/getAllEmails")
	public @ResponseBody List<String> getAllCustomerEmails() {
		return customerService.findAllEmails();
	}

	@GetMapping(value = "/getByEmail", produces = { "application/json", "application/xml" })
	public Customer getCustomerByEmail(@RequestParam("email") String email) {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Customer customer = customerService.findCustomerByEmail(email);
		return customer;
	}
}

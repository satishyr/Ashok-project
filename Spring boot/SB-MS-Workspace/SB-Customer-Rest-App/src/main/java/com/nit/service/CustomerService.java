package com.nit.service;

import java.util.List;

import com.nit.domain.Customer;

public interface CustomerService {

	public boolean saveCustomer(Customer c);

	public Customer getCustomerById(Integer cid);

	public List<String> findAllEmails();

	public Customer findCustomerByEmail(String email);
}

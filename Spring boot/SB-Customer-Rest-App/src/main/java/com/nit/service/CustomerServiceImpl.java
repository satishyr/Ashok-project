package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.domain.Customer;
import com.nit.entity.CustomerEntity;
import com.nit.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl() {
		logger.info("CustomerServiceImpl :: Instantiated");
	}

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepo;

	public boolean saveCustomer(Customer c) {
		logger.debug("saveCustomer() method started");
		CustomerEntity entity = new CustomerEntity();
		BeanUtils.copyProperties(c, entity);
		CustomerEntity savedEntity = customerRepo.save(entity);
		logger.debug("saveCustomer() method ended");
		logger.info("Customer Saved Successfully");
		return savedEntity != null;
	}

	public Customer getCustomerById(Integer cid) {
		logger.debug("getCustomerById() started");
		Optional<CustomerEntity> optional = customerRepo.findById(cid);
		if (optional.isPresent()) {
			CustomerEntity customerEntity = optional.get();
			Customer c = new Customer();
			BeanUtils.copyProperties(customerEntity, c);
			return c;
		}
		logger.debug("getCustomerById() ended");
		logger.warn("CustomerNotFound with given ID ::" + cid);
		return null;
	}

	public List<String> findAllEmails() {
		List<String> emails = customerRepo.findAllEmails();
		return emails;
	}

	public Customer findCustomerByEmail(String email) {
		CustomerEntity customerEntity = customerRepo.findByCustomerEmail(email);
		Customer c = null;
		if (customerEntity != null) {
			c = new Customer();
			BeanUtils.copyProperties(customerEntity, c);
		}
		return c;
	}
}

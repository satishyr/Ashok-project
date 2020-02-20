package com.nit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

	@Query(value = "select customerEmail from CustomerEntity")
	public List<String> findAllEmails();

	@Query(value = "from CustomerEntity where customerEmail=:email")
	public CustomerEntity findByCustomerEmail(String email);
}

package com.tekleads.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekleads.entity.ContactEntity;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactEntity, Integer> {

	@Query(value = "select contactEmail from ContactEntity")
	public List<String> findAllEmails();

	//@Query(value = "from ContactEntity where contactEmail=:email")
	public ContactEntity findByContactEmail(String email);
}
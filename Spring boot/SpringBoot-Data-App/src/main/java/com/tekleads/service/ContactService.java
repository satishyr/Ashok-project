package com.tekleads.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.entity.ContactEntity;
import com.tekleads.repositories.ContactDetailsRepository;

@Service
public class ContactService {

	@Autowired
	private ContactDetailsRepository contactDtlsRepo;

	public void saveContactDetails() {

		ContactEntity entity = new ContactEntity();
		entity.setContactId(302);
		entity.setContactName("John");
		entity.setContactEmail("John.p@gmail.com");

		contactDtlsRepo.save(entity);

		System.out.println("********Record inserted*******");

	}

	public void findContactById(Integer contactId) {
		Optional<ContactEntity> optional = contactDtlsRepo.findById(contactId);
		if (optional.isPresent()) {
			ContactEntity contactEntity = optional.get();
			System.out.println(contactEntity);
		} else {
			System.out.println("Record is not available for :: " + contactId);
		}
	}

	public void findAllContactDtls() {
		Iterable<ContactEntity> contactsDtls = contactDtlsRepo.findAll();
		contactsDtls.forEach(contactEntity -> {
			System.out.println(contactEntity);
		});
	}

	public void finalAllEmails() {
		List<String> emails = contactDtlsRepo.findAllEmails();
		emails.forEach(email -> {
			System.out.println(email);
		});
	}

	public void findCustomerByEmail(String email) {
		ContactEntity customer = contactDtlsRepo.findByContactEmail(email);
		System.out.println(customer);
	}

}

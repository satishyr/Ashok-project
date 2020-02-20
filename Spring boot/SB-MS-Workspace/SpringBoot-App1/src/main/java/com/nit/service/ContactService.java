package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.ContactDao;

@Service
public class ContactService {

	public ContactService() {
		System.out.println("ContactService::Constructor");
	}

	@Autowired(required = false)
	private ContactDao dao;

	public String login() {
		return dao.isValid("admin", "admin@123");
	}
}

package com.nit.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao {

	public String isValid(String uname, String pwd);
}

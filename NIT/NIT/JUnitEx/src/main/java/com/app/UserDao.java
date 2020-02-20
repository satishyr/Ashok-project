package com.app;

public class UserDao {

	public String getUserById(Integer uid) {
		return "Jones";
	}
	
	public String getUserEmailById(Integer uid) {
		if (uid>=100) {
			return "jones@gmail.com";
		}
		
		return null;
		
	}
	
}

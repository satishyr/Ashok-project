package com.example.demo;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptionUsingBcrypt {

	public static String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static void main(String[] args) {
		String encryptedPwd1 = encrypt("ashok");
		
		System.out.println(encryptedPwd1);
		
		if (BCrypt.checkpw("ashok", encryptedPwd1)) {
			System.out.println("Password Matched");
		} else {
			System.out.println("Password Not Matched");
		}
	}
}

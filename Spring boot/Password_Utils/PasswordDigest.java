package com.example.demo;

import java.util.Base64;

public class PasswordDigest {

	public static byte[] computeHash(String x) throws Exception {
		java.security.MessageDigest d = null;
		d = java.security.MessageDigest.getInstance("SHA-1");
		d.reset();
		d.update(x.getBytes());
		return d.digest();
	}

	public static void main(String[] args) throws Exception {
		String digestedPwd1 = Base64.getEncoder().encodeToString(computeHash("abc@123"));
		String digestedPwd2 = Base64.getEncoder().encodeToString(computeHash("abc@123"));
		System.out.println(digestedPwd1);
		System.out.println(digestedPwd2);
	}
}

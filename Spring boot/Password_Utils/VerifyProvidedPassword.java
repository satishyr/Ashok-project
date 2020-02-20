package com.example.demo;

public class VerifyProvidedPassword {
	public static void main(String[] args) {
		// User provided password to validate
		String providedPassword = "myPassword123";

		// Encrypted and Base64 encoded password read from database
		String securePassword = "8Uv3I4D3OM9mE8wNt4YaEXYTwK/rxERcJnSzmbhIUV0=";

		// Salt value stored in database
		String salt = "OPdQBmZDcU3roPrVc4dIPSgoxNc0Gy";

		boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);

		if (passwordMatch) {
			System.out.println("Provided user password " + providedPassword + " is correct.");
		} else {
			System.out.println("Provided password is incorrect");
		}
	}
}
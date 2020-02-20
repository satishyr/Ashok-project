package com.devglan.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.devglan.controller.UserController;
import com.devglan.model.User;
import com.devglan.test.config.TestBeanConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class UserControllerTest {

	@Autowired
	private UserController userController;

	private String password = "password";

	@Test
	public void validateUser_Test_Positive() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setName("test");
		user.setPassword(password);
		userController.save(user);
		ResponseEntity<User> result = userController.getUser(user.getId());
		assertNotNull(result.getBody());
		checkPass(password, user.getPassword());
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}

	private void checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
	}

}

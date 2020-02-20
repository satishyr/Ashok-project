package com.nit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomerNotFoundExceptionMapper {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> m1(){
		ErrorResponse resBody = new ErrorResponse();
		resBody.setErrorCode("CRAP001");
		resBody.setErrorDesc("Invalid Customer ID");
		ResponseEntity<ErrorResponse> entity = new ResponseEntity<ErrorResponse>(resBody, HttpStatus.BAD_REQUEST);
		return entity;
	}
}

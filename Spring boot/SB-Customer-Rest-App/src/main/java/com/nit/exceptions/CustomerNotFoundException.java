package com.nit.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242576117934594753L;

	public CustomerNotFoundException(String msg) {
		super(msg);
	}

	public CustomerNotFoundException() {
	}
}

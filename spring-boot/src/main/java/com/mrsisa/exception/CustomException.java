package com.mrsisa.exception;

public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2335984105108747645L;
	private String message;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}

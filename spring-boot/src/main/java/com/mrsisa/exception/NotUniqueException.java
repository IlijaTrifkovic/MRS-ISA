package com.mrsisa.exception;

public class NotUniqueException extends Exception{
	private static final long serialVersionUID = 5008244100753372024L;
	private String message;

	public NotUniqueException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public String getMessage() {
		return "Vaš '"+message+"' nije jedinstven!";
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
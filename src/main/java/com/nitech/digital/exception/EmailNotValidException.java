package com.nitech.digital.exception;

public class EmailNotValidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EmailNotValidException(String msg) {
		super(msg);
	}
	
	public EmailNotValidException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

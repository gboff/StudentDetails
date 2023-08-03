package com.gb.studentDetails.exceptions;

public class FeesDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public FeesDetailsNotFoundException() {
		super();
	}
	
	public FeesDetailsNotFoundException(String message) {
		super(message);
	}
}

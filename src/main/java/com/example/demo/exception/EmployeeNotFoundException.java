package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7034897190745766939L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String msg) {
		super(msg);

	}
}

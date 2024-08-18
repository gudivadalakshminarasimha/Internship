package com.example.EmployeeManagement.Exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
	private String msg="user not found";

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public UserNotFoundException() {
		super();
	}
	
}

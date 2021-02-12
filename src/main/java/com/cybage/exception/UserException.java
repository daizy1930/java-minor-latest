package com.cybage.exception;

import javax.servlet.ServletException;

public class UserException extends ServletException{
	public UserException(String msg) {
		super(msg);
	}
}

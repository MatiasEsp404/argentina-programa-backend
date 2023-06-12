package com.matias.argentinaprograma.config.exception.runtime;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends RuntimeException {

	public UserAlreadyExistException(String message) {
		super(message);
	}

}

package com.matias.argentinaprograma.config.exception.runtime;

public class UserAlreadyExistException extends RuntimeException {

  public UserAlreadyExistException(String message) {
    super(message);
  }

}

package com.matias.argentinaprograma.config.exception.runtime;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String message) {
    super(message);
  }

}

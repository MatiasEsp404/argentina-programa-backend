package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;


public class AuthenticationRequest {

  @Email(message = "El email tiene un formato invalido")
  private String email;

  @Length(min = 8, max = 16, message = "El password debe tener entre 8 y 16 caracteres")
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

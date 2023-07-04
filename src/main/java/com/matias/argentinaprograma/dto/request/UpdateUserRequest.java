package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

public class UpdateUserRequest {

  @Nullable
  @Email(message = "El email tiene un formato invalido")
  private String email;

  @Nullable
  @Length(min = 8, max = 16, message = "El password debe tener entre 8 y 16 caracteres")
  private String password;

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  @Nullable
  public String getPassword() {
    return password;
  }

  public void setPassword(@Nullable String password) {
    this.password = password;
  }
}

package com.matias.argentinaprograma.dto.request;

import org.springframework.lang.Nullable;

public class UpdateUserRequest {

  @Nullable
  private String email;

  @Nullable
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

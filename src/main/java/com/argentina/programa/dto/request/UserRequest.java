package com.argentina.programa.dto.request;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserRequest {

  @Email(message = "The email has invalid format.")
  private String email;

  @Length(min = 6, max = 32, message = "The password must be between 6 and 32 characters.")
  private String password;

}

package com.matias.argentinaprograma.dto.request;

import com.matias.argentinaprograma.config.security.constants.Validations;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class RegisterRequest {

  @NotBlank(message = "El nombre no puede estar en blanco")
  @Pattern(regexp = Validations.CHARACTERS_WITH_WHITE_SPACES, message = "El nombre solo puede contener caracteres alfabeticos y espacios")
  private String firstName;

  @NotBlank(message = "El apellido no puede estar en blanco")
  @Pattern(regexp = Validations.CHARACTERS_WITH_WHITE_SPACES, message = "El apellido solo puede contener caracteres alfabeticos y espacios")
  private String lastName;

  @NotBlank(message = "El email no puede estar en blanco")
  @Email(message = "El email tiene un formato invalido")
  private String email;

  @NotBlank(message = "El password no puede estar en blanco")
  @Length(min = 8, max = 16, message = "El password debe tener entre 8 y 16 caracteres")
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

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

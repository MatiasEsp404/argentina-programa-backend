package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequest {

	@Email(message = "El email tiene un formato invalido")
	private String email;

	@Length(min = 8, max = 16, message = "El password debe tener entre 8 y 16 caracteres")
	private String password;
	
}

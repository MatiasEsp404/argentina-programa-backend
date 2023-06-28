package com.matias.argentinaprograma.dto.request;

import com.matias.argentinaprograma.config.security.constants.Validations;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {

	@Nullable
	@Pattern(regexp = Validations.CHARACTERS_WITH_WHITE_SPACES, message = "El nombre solo puede contener caracteres alfabeticos y espacios")
	private String firstName;

	@Nullable
	@Pattern(regexp = Validations.CHARACTERS_WITH_WHITE_SPACES, message = "El apellido solo puede contener caracteres alfabeticos y espacios")
	private String lastName;

	@Nullable
	@Email(message = "El email tiene un formato invalido")
	private String email;
	
	@Nullable
	@Length(min = 8, max = 16, message = "El password debe tener entre 8 y 16 caracteres")
	private String password;

}

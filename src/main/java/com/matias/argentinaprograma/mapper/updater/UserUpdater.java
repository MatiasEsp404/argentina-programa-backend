package com.matias.argentinaprograma.mapper.updater;

import com.matias.argentinaprograma.config.exception.runtime.UserAlreadyExistException;
import com.matias.argentinaprograma.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.matias.argentinaprograma.dto.request.UpdateUserRequest;
import com.matias.argentinaprograma.model.UserEntity;

@Component
public class UserUpdater {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserRepository userRepository;

	public UserEntity update(UpdateUserRequest updateUserRequest, UserEntity userEntity) {
		String firstName = updateUserRequest.getFirstName();
		if (firstName != null) {
			userEntity.setFirstName(firstName);
		}
		String lastName = updateUserRequest.getLastName();
		if (lastName != null) {
			userEntity.setLastName(lastName);
		}
		String email = updateUserRequest.getEmail();
		if (email != null) {
			if (userRepository.findByEmail(email) != null) {
				throw new UserAlreadyExistException("Email is already in use.");
			}
			userEntity.setEmail(email); // TODO El cambio de email debería estar sujeto a una confirmación por email.
		}
		String password = updateUserRequest.getPassword();
		if (password != null) {
			userEntity.setPassword(passwordEncoder.encode(password));
		}
		return userEntity;
	}

}

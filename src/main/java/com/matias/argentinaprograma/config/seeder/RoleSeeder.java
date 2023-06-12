package com.matias.argentinaprograma.config.seeder;

import com.matias.argentinaprograma.model.UserEntity;
import com.matias.argentinaprograma.repository.IUserRepository;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.model.RoleEntity;
import com.matias.argentinaprograma.repository.IRoleRepository;

@Component
public class RoleSeeder {

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		createRoleTable();
		createAdmin();
	}

	private void createAdmin() {
		if (userRepository.count() < 1) {
			userRepository.save(buildAdmin());
		}
	}

	private UserEntity buildAdmin() {
		return UserEntity.builder()
				.firstName("Matias")
				.lastName("Espinola")
				.email("matias@gmail.com")
				.password(passwordEncoder.encode("Pass1234"))
				.role(roleRepository.findByName(Role.ADMIN.getFullRoleName()))
				.softDeleted(false)
				.build();
	}

	private void createRoleTable() {
		if (roleRepository.count() < 2) {
			roleRepository.saveAll(Arrays.asList(buildRole(Role.USER), buildRole(Role.ADMIN)));
		}
	}

	private RoleEntity buildRole(Role role) {
		return RoleEntity.builder().name(role.getFullRoleName()).build();
	}

}

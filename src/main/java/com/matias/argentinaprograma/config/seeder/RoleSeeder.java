package com.matias.argentinaprograma.config.seeder;

import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.model.RoleEntity;
import com.matias.argentinaprograma.model.UserEntity;
import com.matias.argentinaprograma.repository.IRoleRepository;
import com.matias.argentinaprograma.repository.IUserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
    createUser();
  }

  private void createUser() {
    String userEmail = "foo@outlook.com";
    UserEntity user = userRepository.findByEmail(userEmail);
    if (user == null) {
      userRepository.save(buildUser(userEmail));
    }
  }

  private UserEntity buildUser(String email) {
    UserEntity entity = new UserEntity();
    entity.setEmail(email);
    entity.setPassword(passwordEncoder.encode("ArgProg2022"));
    entity.setRole(roleRepository.findByName(Role.USER.getFullRoleName()));
    entity.setSoftDeleted(false);
    return entity;
  }

  private void createAdmin() {
    if (userRepository.count() < 1) {
      userRepository.save(buildAdmin());
    }
  }

  private UserEntity buildAdmin() {
    UserEntity entity = new UserEntity();
    entity.setEmail("matias@gmail.com");
    entity.setPassword(passwordEncoder.encode("Pass1234"));
    entity.setRole(roleRepository.findByName(Role.ADMIN.getFullRoleName()));
    entity.setSoftDeleted(false);
    return entity;
  }

  private void createRoleTable() {
    if (roleRepository.count() < 2) {
      roleRepository.saveAll(Arrays.asList(buildRole(Role.USER), buildRole(Role.ADMIN)));
    }
  }

  private RoleEntity buildRole(Role role) {
    RoleEntity entity = new RoleEntity();
    entity.setName(role.getFullRoleName());
    return entity;
  }

}

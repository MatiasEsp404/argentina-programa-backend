package com.argentina.programa.util.seeder;

import com.argentina.programa.model.RoleEntity;
import com.argentina.programa.model.UserEntity;
import com.argentina.programa.repository.IRoleRepository;
import com.argentina.programa.repository.IUserRepository;
import com.argentina.programa.security.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private IRoleRepository roleRepository;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    createUserTable();
  }

  private void createUserTable() {
    createRoles();
    createOwner();
  }

  private void createRoles() {
    if (roleRepository.count() < 2) {
      roleRepository.saveAll(List.of(buildRole(Role.USER), buildRole(Role.OWNER)));
    }
  }

  private RoleEntity buildRole(Role role) {
    RoleEntity roleEntity = new RoleEntity();
    roleEntity.setName(role.getFullRoleName());
    return roleEntity;
  }

  private void createOwner() {
    if (userRepository.count() < 1) {
      userRepository.save(buildOwner());
    }
  }

  private UserEntity buildOwner() {
    UserEntity userEntity = new UserEntity();
    userEntity.setEmail("foo@outlook.com");
    userEntity.setPassword(passwordEncoder.encode("ArgProg2022"));
    userEntity.setRole(roleRepository.findByName(Role.OWNER.getFullRoleName()));
    userEntity.setIsBanned(false);
    return userEntity;
  }

}

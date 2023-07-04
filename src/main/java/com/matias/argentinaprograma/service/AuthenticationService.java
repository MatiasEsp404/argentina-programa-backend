package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.config.exception.runtime.InvalidCredentialsException;
import com.matias.argentinaprograma.config.exception.runtime.UserAlreadyExistException;
import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.config.security.util.JwtUtils;
import com.matias.argentinaprograma.dto.request.AuthenticationRequest;
import com.matias.argentinaprograma.dto.request.RegisterRequest;
import com.matias.argentinaprograma.dto.response.AuthenticationResponse;
import com.matias.argentinaprograma.dto.response.RegisterResponse;
import com.matias.argentinaprograma.mapper.UserMapper;
import com.matias.argentinaprograma.model.RoleEntity;
import com.matias.argentinaprograma.model.UserEntity;
import com.matias.argentinaprograma.repository.IRoleRepository;
import com.matias.argentinaprograma.repository.IUserRepository;
import com.matias.argentinaprograma.service.abstraction.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {


  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IRoleRepository roleRepository;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private AuthenticationManager authManager;

  @Override
  public RegisterResponse register(RegisterRequest registerRequest) {
    if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
      throw new UserAlreadyExistException("El email ya esta en uso");
    }

    RoleEntity userRoleEntity = roleRepository.findByName(Role.USER.getFullRoleName());
    if (userRoleEntity == null) {
      throw new EntityNotFoundException("Falta un registro en la tabla de roles");
    }

    UserEntity userEntity = userMapper.toUserEntity(registerRequest);
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    userEntity.setSoftDeleted(false);
    userEntity.setRole(userRoleEntity);
    userEntity = userRepository.save(userEntity);

    RegisterResponse registerResponse = userMapper.toRegisterResponse(userEntity);
    registerResponse.setToken(jwtUtils.generateToken(userEntity));
    return registerResponse;
  }

  @Override
  public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
    Authentication authentication;
    try {
      authentication = authManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getEmail(),
              authenticationRequest.getPassword()
          )
      );
    } catch (AuthenticationException e) {
      throw new InvalidCredentialsException("Email o password invalidos");
    }

    String jwt = jwtUtils.generateToken((UserDetails) authentication.getPrincipal());

    AuthenticationResponse response = new AuthenticationResponse();
    response.setToken(jwt);
    return response;
  }

}

package com.argentina.programa.service;

import com.argentina.programa.dto.request.UserRequest;
import com.argentina.programa.dto.response.UserResponse;
import com.argentina.programa.exception.EntityNotFoundException;
import com.argentina.programa.mapper.UserMapper;
import com.argentina.programa.model.UserEntity;
import com.argentina.programa.repository.IUserRepository;
import com.argentina.programa.service.abstraction.IPatchOwner;
import com.argentina.programa.updater.UserUpdater;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IPatchOwner {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserUpdater userUpdater;

  @Override
  public UserResponse patch(UserRequest request) {
    UserEntity user = getOwner();
    user = userUpdater.patch(user, request);
    user = userRepository.save(user);
    return userMapper.toUserResponse(user);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return getOwner(email);
  }

  private UserEntity getOwner() {
    Optional<UserEntity> optionalUser = userRepository.findById(1L);
    if (optionalUser.isEmpty()) {
      throw new EntityNotFoundException("Owner not found.");
    }
    return optionalUser.get();
  }

  private UserEntity getOwner(String username) {
    UserEntity userEntity = userRepository.findByEmail(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("User not found.");
    }
    return userEntity;
  }

}

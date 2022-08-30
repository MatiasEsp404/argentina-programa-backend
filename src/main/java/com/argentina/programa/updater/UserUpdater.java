package com.argentina.programa.updater;

import com.argentina.programa.dto.request.UserRequest;
import com.argentina.programa.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUpdater {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserEntity patch(UserEntity original, UserRequest update){
    if (update.getEmail() != null){
      original.setEmail(update.getEmail());
    }
    if (update.getPassword() != null){
      original.setPassword(passwordEncoder.encode(update.getPassword()));
    }
    return original;
  }

}

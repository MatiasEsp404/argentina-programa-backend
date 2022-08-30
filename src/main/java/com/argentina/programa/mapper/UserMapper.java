package com.argentina.programa.mapper;

import com.argentina.programa.dto.response.UserResponse;
import com.argentina.programa.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserResponse toUserResponse(UserEntity entity){
    UserResponse response = new UserResponse();
    response.setEmail(entity.getEmail());
    response.setPassword(entity.getPassword());
    return response;
  }

}

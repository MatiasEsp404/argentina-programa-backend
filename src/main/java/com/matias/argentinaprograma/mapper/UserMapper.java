package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.RegisterRequest;
import com.matias.argentinaprograma.dto.response.RegisterResponse;
import com.matias.argentinaprograma.dto.response.UserResponse;
import com.matias.argentinaprograma.model.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserEntity toUserEntity(RegisterRequest request) {
    UserEntity entity = new UserEntity();
    entity.setEmail(request.getEmail());
    entity.setPassword(request.getPassword());
    return entity;
  }

  public RegisterResponse toRegisterResponse(UserEntity entity) {
    RegisterResponse response = new RegisterResponse();
    response.setId(entity.getId());
    response.setEmail(entity.getEmail());
    return response;
  }

  public List<UserResponse> toListUserResponse(List<UserEntity> entities) {
    List<UserResponse> userResponses = new ArrayList<>();
    for (UserEntity entity : entities) {
      userResponses.add(toUserResponse(entity));
    }
    return userResponses;
  }

  public UserResponse toUserResponse(UserEntity entity) {
    UserResponse response = new UserResponse();
    response.setId(entity.getId());
    response.setEmail(entity.getEmail());
    response.setRole(entity.getRole().getName());
    return response;
  }

}

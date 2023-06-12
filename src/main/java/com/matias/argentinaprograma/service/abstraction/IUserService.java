package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.UpdateUserRequest;
import com.matias.argentinaprograma.dto.response.ListUsersResponse;
import com.matias.argentinaprograma.dto.response.UserResponse;

public interface IUserService {

  ListUsersResponse listActiveUsers();

  UserResponse getUserAuthenticated();

  void update(Integer id, UpdateUserRequest updateUserRequest);

  void delete(Integer id);


}

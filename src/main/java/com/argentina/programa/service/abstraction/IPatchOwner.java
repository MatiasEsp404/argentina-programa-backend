package com.argentina.programa.service.abstraction;

import com.argentina.programa.dto.request.UserRequest;
import com.argentina.programa.dto.response.UserResponse;

public interface IPatchOwner {

  UserResponse patch(UserRequest request);

}

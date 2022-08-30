package com.argentina.programa.service.abstraction;

import com.argentina.programa.dto.request.AuthenticationRequest;
import com.argentina.programa.dto.response.AuthenticationResponse;

public interface IAuthenticationService {

  AuthenticationResponse login(AuthenticationRequest authenticationRequest);

}

package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.AuthenticationRequest;
import com.matias.argentinaprograma.dto.request.RegisterRequest;
import com.matias.argentinaprograma.dto.response.AuthenticationResponse;
import com.matias.argentinaprograma.dto.response.RegisterResponse;

public interface IAuthenticationService {

	RegisterResponse register(RegisterRequest registerRequest);

	AuthenticationResponse login(AuthenticationRequest authenticationRequest);

}

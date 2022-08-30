package com.argentina.programa.service;

import com.argentina.programa.dto.response.AuthenticationResponse;
import com.argentina.programa.exception.InvalidCredentialsException;
import com.argentina.programa.security.filter.JwtUtils;
import com.argentina.programa.dto.request.AuthenticationRequest;
import com.argentina.programa.service.abstraction.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private JwtUtils jwtUtils;

  @Override
  public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
    Authentication authentication;
    try {
      authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
          authenticationRequest.getEmail(), authenticationRequest.getPassword()));
    } catch (Exception e) {
      throw new InvalidCredentialsException("Invalid email or password.");
    }
    String jwt = jwtUtils.generateToken((UserDetails) authentication.getPrincipal());
    return new AuthenticationResponse(jwt);
  }

}

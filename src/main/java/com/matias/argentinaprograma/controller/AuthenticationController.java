package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.AuthenticationRequest;
import com.matias.argentinaprograma.dto.request.RegisterRequest;
import com.matias.argentinaprograma.dto.response.AuthenticationResponse;
import com.matias.argentinaprograma.dto.response.RegisterResponse;
import com.matias.argentinaprograma.dto.response.UserResponse;
import com.matias.argentinaprograma.service.abstraction.IAuthenticationService;
import com.matias.argentinaprograma.service.abstraction.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.AUTH)
public class AuthenticationController implements Paths {

  @Autowired
  private IAuthenticationService authService;

  @Autowired
  private IUserService userService;

  @PostMapping(path = REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
  }

  @PostMapping(path = LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> login(
      @RequestBody AuthenticationRequest authenticationRequest) {
    return ResponseEntity.ok().body(authService.login(authenticationRequest));
  }

  @GetMapping(path = ME, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponse> getUser() {
    return ResponseEntity.ok().body(userService.getUserAuthenticated());
  }

}
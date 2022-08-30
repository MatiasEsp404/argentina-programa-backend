package com.argentina.programa.controller;

import com.argentina.programa.dto.request.AuthenticationRequest;
import com.argentina.programa.dto.response.AuthenticationResponse;
import com.argentina.programa.service.abstraction.IAuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin()
public class AuthenticationController {

  @Autowired
  private IAuthenticationService authService;

  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> login(
      @Valid @RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok().body(authService.login(request));
  }

}

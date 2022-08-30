package com.argentina.programa.controller;

import com.argentina.programa.dto.request.UserRequest;
import com.argentina.programa.dto.response.UserResponse;
import com.argentina.programa.service.abstraction.IPatchOwner;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin()
public class UserController {

  @Autowired
  private IPatchOwner patchOwner;


  @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<UserResponse> patch(@Valid @RequestBody UserRequest request) {
    UserResponse response = patchOwner.patch(request);
    return ResponseEntity.ok().body(response);
  }

}

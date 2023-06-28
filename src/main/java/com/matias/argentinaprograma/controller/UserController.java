package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.UpdateUserRequest;
import com.matias.argentinaprograma.dto.response.ListUsersResponse;
import com.matias.argentinaprograma.service.abstraction.IUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.USERS)
public class UserController implements Paths {

	@Autowired
	private IUserService userService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListUsersResponse> listActiveUsers() {
		return ResponseEntity.ok().body(userService.listActiveUsers());
	}

	@DeleteMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping(value = ID, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
		userService.update(id, updateUserRequest);
		return ResponseEntity.noContent().build();
	}

}
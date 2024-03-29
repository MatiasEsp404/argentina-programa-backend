package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.service.abstraction.ITrabajoService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.TRABAJO)
public class TrabajoController implements Paths {

  @Autowired
  private ITrabajoService trabajoService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TrabajoResponse>> getAll() {
    return ResponseEntity.ok(trabajoService.getAll());
  }

  @GetMapping(path = ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoResponse> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(trabajoService.getBy(id));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoResponse> create(@Valid @RequestBody TrabajoRequest request) {
    TrabajoResponse response = trabajoService.create(request);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path(ID)
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(location).body(response);
  }

  @PutMapping(path = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoResponse> update(@PathVariable Integer id, @Valid @RequestBody TrabajoRequest request) {
    return ResponseEntity.ok().body(trabajoService.update(id, request));
  }

  @DeleteMapping(path = ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    trabajoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

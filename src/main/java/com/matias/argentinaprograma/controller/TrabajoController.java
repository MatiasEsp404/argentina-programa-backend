package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.model.TrabajoEntity;
import com.matias.argentinaprograma.service.TrabajoService;
import java.net.URI;
import java.util.List;
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
@RequestMapping(path = "/api/trabajo")
public class TrabajoController {

  @Autowired
  private TrabajoService trabajoService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TrabajoEntity>> getAll() {
    return ResponseEntity.ok(trabajoService.getAll());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoEntity> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(trabajoService.getBy(id));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoEntity> create(@RequestBody TrabajoRequest request) {
    TrabajoEntity response = trabajoService.create(request);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(location).body(response);
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TrabajoEntity> update(@PathVariable Integer id,
      @RequestBody TrabajoRequest request) {
    return ResponseEntity.ok().body(trabajoService.update(id, request));
  }

  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    trabajoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

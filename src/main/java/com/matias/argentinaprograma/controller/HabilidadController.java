package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.model.HabilidadEntity;
import com.matias.argentinaprograma.service.HabilidadService;
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
@RequestMapping(path = "/api/habilidad")
public class HabilidadController {

  @Autowired
  private HabilidadService habilidadService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<HabilidadEntity>> getAll() {
    return ResponseEntity.ok(habilidadService.getAll());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadEntity> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(habilidadService.getBy(id));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadEntity> create(@RequestBody HabilidadRequest request) {
    HabilidadEntity response = habilidadService.create(request);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(location).body(response);
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadEntity> update(@PathVariable Integer id,
      @RequestBody HabilidadRequest request) {
    return ResponseEntity.ok().body(habilidadService.update(id, request));
  }

  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    habilidadService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

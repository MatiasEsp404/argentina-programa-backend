package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import com.matias.argentinaprograma.service.abstraction.IHabilidadService;
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
@RequestMapping(path = Paths.HABILIDAD)
public class HabilidadController implements Paths {

  @Autowired
  private IHabilidadService habilidadService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<HabilidadResponse>> getAll() {
    return ResponseEntity.ok(habilidadService.getAll());
  }

  @GetMapping(path = ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadResponse> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(habilidadService.getBy(id));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadResponse> create(@Valid @RequestBody HabilidadRequest request) {
    HabilidadResponse response = habilidadService.create(request);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path(ID)
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(location).body(response);
  }

  @PutMapping(path = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HabilidadResponse> update(@PathVariable Integer id, @Valid @RequestBody HabilidadRequest request) {
    return ResponseEntity.ok().body(habilidadService.update(id, request));
  }

  @DeleteMapping(path = ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    habilidadService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

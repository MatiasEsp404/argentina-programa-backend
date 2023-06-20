package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.dto.response.EstudioResponse;
import com.matias.argentinaprograma.service.abstraction.IEstudioService;
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
@RequestMapping(path = Paths.ESTUDIO)
public class EstudioController implements Paths {

  @Autowired
  private IEstudioService estudioService;

  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<List<EstudioResponse>> getAll() {
    return ResponseEntity.ok(estudioService.getAll());
  }

  @GetMapping(
      path = ID,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<EstudioResponse> getById(
      @PathVariable Integer id
  ) {
    return ResponseEntity.ok(estudioService.getById(id));
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<EstudioResponse> create(
      @RequestBody EstudioRequest request
  ) {
    EstudioResponse response = estudioService.create(request);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path(ID)
        .buildAndExpand(response.getId())
        .toUri();
    return ResponseEntity.created(location).body(response);
  }

  @PutMapping(
      path = ID,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<EstudioResponse> update(
      @PathVariable Integer id,
      @RequestBody EstudioRequest request
  ) {
    return ResponseEntity.ok().body(estudioService.update(id, request));
  }

  @DeleteMapping(
      path = ID,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Void> delete(
      @PathVariable Integer id
  ) {
    estudioService.delete(id);
    return ResponseEntity.noContent().build();
  }

}

package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.model.DatosBasicosEntity;
import com.matias.argentinaprograma.service.DatosBasicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/datos")
public class DatosBasicosController {

  @Autowired
  private DatosBasicosService datosBasicosService;

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DatosBasicosEntity> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(datosBasicosService.getBy(id));
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DatosBasicosEntity> update(@PathVariable Integer id,
      @RequestBody DatosBasicosRequest request) {
    return ResponseEntity.ok().body(datosBasicosService.update(request, id));
  }

}

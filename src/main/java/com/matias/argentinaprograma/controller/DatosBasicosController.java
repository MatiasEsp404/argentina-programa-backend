package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.dto.response.DatosBasicosResponse;
import com.matias.argentinaprograma.service.abstraction.IDatosBasicosService;
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
@RequestMapping(path = Paths.DATOS_BASICOS)
public class DatosBasicosController implements Paths {

  @Autowired
  private IDatosBasicosService datosBasicosService;

  @GetMapping(path = ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DatosBasicosResponse> getBy(@PathVariable Integer id) {
    return ResponseEntity.ok(datosBasicosService.getBy(id));
  }

  @PutMapping(path = ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DatosBasicosResponse> update(@PathVariable Integer id,
      @RequestBody DatosBasicosRequest request) {
    return ResponseEntity.ok().body(datosBasicosService.update(request, id));
  }

}

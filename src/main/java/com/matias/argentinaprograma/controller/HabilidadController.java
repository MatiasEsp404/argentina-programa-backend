package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import com.matias.argentinaprograma.service.abstraction.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.HABILIDAD)
public class HabilidadController {

  @Autowired
  private IHabilidadService habilidadService;

  @GetMapping
  public ResponseEntity<List<HabilidadResponse>> getAll() {
    return ResponseEntity.ok(habilidadService.getAll());
  }

}

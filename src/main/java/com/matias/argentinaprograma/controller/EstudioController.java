package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.response.EstudioResponse;
import com.matias.argentinaprograma.service.abstraction.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.ESTUDIO)
public class EstudioController {

  @Autowired
  private IEstudioService estudioService;

  @GetMapping
  public ResponseEntity<List<EstudioResponse>> getAll() {
    return ResponseEntity.ok(estudioService.getAll());
  }

}

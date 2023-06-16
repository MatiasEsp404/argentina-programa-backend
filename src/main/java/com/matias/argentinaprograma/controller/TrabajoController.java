package com.matias.argentinaprograma.controller;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.service.abstraction.ITrabajoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = Paths.TRABAJO)
public class TrabajoController {

  @Autowired
  private ITrabajoService trabajoService;

  @GetMapping
  public ResponseEntity<List<TrabajoResponse>> getAll() {
    return ResponseEntity.ok(trabajoService.getAll());
  }

}

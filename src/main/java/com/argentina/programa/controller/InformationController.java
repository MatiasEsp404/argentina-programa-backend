package com.argentina.programa.controller;

import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.dto.response.InformationResponse;
import com.argentina.programa.service.abstraction.IGetInformation;
import com.argentina.programa.service.abstraction.IPatchInformation;
import com.argentina.programa.service.abstraction.IUpdateFormation;
import com.argentina.programa.service.abstraction.IUpdateProject;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/information")
@CrossOrigin
public class InformationController {

  @Autowired
  private IGetInformation getInformation;

  @Autowired
  private IPatchInformation patchInformation;
  
  @Autowired
  private IUpdateFormation updateFormation;
  
  @Autowired
  private IUpdateProject updateProject;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<InformationResponse> get() {
    InformationResponse response = getInformation.get();
    return ResponseEntity.ok().body(response);
  }

  @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<InformationResponse> update(
      @Valid @RequestBody InformationRequest request) {
    updateFormation.update(request.getFormations());
    updateProject.update(request.getProjects());
    InformationResponse response = patchInformation.patch(request);
    return ResponseEntity.ok().body(response);
  }


}

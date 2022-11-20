package com.argentina.programa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentina.programa.dto.request.FormationRequest;
import com.argentina.programa.model.FormationEntity;
import com.argentina.programa.repository.IFormationRepository;
import com.argentina.programa.service.abstraction.IUpdateFormation;

@Service
public class FormationService implements IUpdateFormation {

  @Autowired
  private IFormationRepository repository;
  
  @Override
  public void update(List<FormationRequest> formationRequest) {
    repository.deleteAll();
    if(formationRequest == null) {
      return;
    }
    repository.saveAll(toListFormationEntity(formationRequest));
  }
  
  private List<FormationEntity> toListFormationEntity(List<FormationRequest> requests){
    List<FormationEntity> entities = new ArrayList<>();
    for(FormationRequest request : requests) {
      entities.add(buildFormationEntity(request));
    }
    return entities;
  }
  
  private FormationEntity buildFormationEntity(FormationRequest request){
    return FormationEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .date(request.getDate())
        .build();
  }

}

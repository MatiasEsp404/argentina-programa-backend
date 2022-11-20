package com.argentina.programa.service.abstraction;

import java.util.List;
import com.argentina.programa.dto.request.FormationRequest;

public interface IUpdateFormation {

  void update(List<FormationRequest> formationRequest);
  
}

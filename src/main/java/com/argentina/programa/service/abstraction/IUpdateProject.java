package com.argentina.programa.service.abstraction;

import java.util.List;
import com.argentina.programa.dto.request.ProjectRequest;

public interface IUpdateProject {

  void update(List<ProjectRequest> projectRequest);
  
}

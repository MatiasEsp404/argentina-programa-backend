package com.argentina.programa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentina.programa.dto.request.ProjectRequest;
import com.argentina.programa.model.ProjectEntity;
import com.argentina.programa.repository.IProjectRepository;
import com.argentina.programa.service.abstraction.IUpdateProject;

@Service
public class ProjectService implements IUpdateProject {

  @Autowired
  private IProjectRepository repository;

  @Override
  public void update(List<ProjectRequest> projectRequest) {
    repository.deleteAll();
    if(projectRequest == null) {
      return;
    }
    repository.saveAll(toListProjectEntity(projectRequest));
  }

  private List<ProjectEntity> toListProjectEntity(List<ProjectRequest> requests) {
    List<ProjectEntity> entities = new ArrayList<>();
    for (ProjectRequest request : requests) {
      entities.add(buildProjectEntity(request));
    }
    return entities;
  }

  private ProjectEntity buildProjectEntity(ProjectRequest request) {
    return ProjectEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .url(request.getUrl())
        .build();
  }
}

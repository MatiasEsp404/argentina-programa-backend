package com.argentina.programa.mapper;

import com.argentina.programa.dto.response.FormationResponse;
import com.argentina.programa.dto.response.InformationResponse;
import com.argentina.programa.dto.response.ProjectResponse;
import com.argentina.programa.model.FormationEntity;
import com.argentina.programa.model.InformationEntity;
import com.argentina.programa.model.ProjectEntity;
import com.argentina.programa.repository.IFormationRepository;
import com.argentina.programa.repository.IProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformationMapper {

  @Autowired
  private IFormationRepository formationRepository;
  
  @Autowired
  private IProjectRepository projectRepository;
  
  public InformationResponse toInformationResponse(InformationEntity entity) {
    return InformationResponse.builder()
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .email(entity.getEmail())
        .phoneNumber(entity.getPhoneNumber())
        .country(entity.getCountry())
        .province(entity.getProvince())
        .location(entity.getLocation())
        .linkedin(entity.getLinkedin())
        .gitHub(entity.getGitHub())
        .seniority(entity.getSeniority())
        .coverImage(entity.getCoverImage())
        .profilePicture(entity.getProfilePicture())
        .formations(getAllFormations())
        .projects(getAllProjects())
        .build();
  }

  private List<FormationResponse> getAllFormations() {
    List<FormationEntity> formationsEntity = formationRepository.findAll();
    List<FormationResponse> formations = new ArrayList<>();
    for(FormationEntity formation : formationsEntity) {
      formations.add(buildFormationResponse(formation));
    }
    return formations;
  }
  
  private List<ProjectResponse> getAllProjects(){
    List<ProjectEntity> projectsEntity = projectRepository.findAll();
    List<ProjectResponse> projects = new ArrayList<>();
    for(ProjectEntity project : projectsEntity) {
      projects.add(buildProjectResponse(project));
    }
    return projects;
  }

  private FormationResponse buildFormationResponse(FormationEntity entity) {
    return FormationResponse.builder()
        .name(entity.getName())
        .description(entity.getDescription())
        .date(entity.getDate()) 
        .build();
  }
  
  private ProjectResponse buildProjectResponse(ProjectEntity entity) {
    return ProjectResponse.builder()
        .name(entity.getName())
        .description(entity.getDescription())
        .url(entity.getUrl())        
        .build();
  }

}

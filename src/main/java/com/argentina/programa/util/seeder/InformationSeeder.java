package com.argentina.programa.util.seeder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.argentina.programa.model.FormationEntity;
import com.argentina.programa.model.InformationEntity;
import com.argentina.programa.model.ProjectEntity;
import com.argentina.programa.repository.IFormationRepository;
import com.argentina.programa.repository.IInformationRepository;
import com.argentina.programa.repository.IProjectRepository;

@Component
public class InformationSeeder {

  @Autowired
  private IInformationRepository informationRepository;

  @Autowired
  private IFormationRepository formationRepository;

  @Autowired
  private IProjectRepository projectRepository;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    if (informationRepository.count() < 1) {
      informationRepository.save(buildInformation());
      formationRepository.saveAll(buildFormations());
      projectRepository.saveAll(buildProjects());
    }
  }

  private List<ProjectEntity> buildProjects() {
    List<ProjectEntity> entities = new ArrayList<>();
    entities.add(buildProject("argentina-programa-frontend",
        "Entrega del proyecto integrador de Argentina Programa. Portfolio Web FrontEnd.",
        "https://github.com/MatiasEsp404/argentina-programa-frontend"));
    entities.add(buildProject("argentina-programa-backend",
        "Entrega del proyecto integrador de Argentina Programa. Portfolio Web BackEnd.",
        "https://github.com/MatiasEsp404/argentina-programa-backend"));
    return entities;
  }

  private ProjectEntity buildProject(String name, String description, String url) {
    return ProjectEntity.builder().name(name).description(description).url(url).build();
  }

  private List<FormationEntity> buildFormations() {
    List<FormationEntity> entities = new ArrayList<>();
    entities.add(buildFormation("Argentina Programa",
        "HTML, CSS, JavaScript, TypeScript, Angular, MySQL, Java, SpringBoot, Heroku, FireBase",
        "16-03-2022"));
    entities.add(buildFormation("Codo a Codo",
        "HTML, CSS, JavaScript, Vue, Netlify, MySQL, Java, SpringBoot, Heroku", "19-12-2021"));
    return entities;
  }

  private FormationEntity buildFormation(String name, String description, String date) {
    return FormationEntity.builder().name(name).description(description).date(date).build();
  }

  private InformationEntity buildInformation() {
    return InformationEntity.builder().firstName("Claudio Matias").lastName("Correa Espinola")
        .email("foo@email.com").phoneNumber("5491112345678").country("Argentina")
        .province("Buenos Aires").location("Almirante Brown")
        .linkedin("linkedin.com/in/MatiasEsp404/").gitHub("github.com/MatiasEsp404")
        .seniority("Java Backend Develop Jr")
        .profilePicture(
            "https://1.bp.blogspot.com/-MKUK2ib5GJ4/UQUyUb4zQ5I/AAAAAAAAAgY/TTMX2jRCp3s/s1600/pikachu+1.jpg")
        .coverImage(
            "https://secure.static.tumblr.com/0e3b2e30312ca426d8a8f29a99e01aeb/ge4upkh/HMcmzna1m/tumblr_static_tumblr_static_tumblr_static_pokemon_banner.png")
        .build();
  }

}

package com.argentina.programa.util.seeder;

import com.argentina.programa.model.InformationEntity;
import com.argentina.programa.repository.IInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InformationSeeder {

  @Autowired
  private IInformationRepository repository;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    if (repository.count() < 1) {
      repository.save(buildInformation());
    }
  }

  private InformationEntity buildInformation() {
    return InformationEntity.builder()
        .firstName("Claudio Matias")
        .lastName("Correa Espinola")
        .email("foo@email.com")
        .phoneNumber("5491112345678")
        .country("Argentina")
        .province("Buenos Aires")
        .location("Almirante Brown")
        .linkedin("linkedin.com/in/MatiasEsp404/")
        .gitHub("github.com/MatiasEsp404")
        .seniority("Java Backend Develop Jr")
        .profilePicture(
            "https://media-exp1.licdn.com/dms/image/C4D03AQHX8KoFv_0qeg/profile-displayphoto-shrink_800_800/0/1658791940443?e=1666828800&v=beta&t=tIB9GyhT7efmcGTr6IhlXhxZOI9jtysZHA6h0FRFBfE")
        .coverImage(
            "https://media-exp1.licdn.com/dms/image/C4D16AQGYmEHkYSst3Q/profile-displaybackgroundimage-shrink_350_1400/0/1661114015065?e=1666828800&v=beta&t=eOdJHuweJAl_tM_wNhmguRE2tmy9kzskhnR_UVd3FoY")
        .build();

  }

}

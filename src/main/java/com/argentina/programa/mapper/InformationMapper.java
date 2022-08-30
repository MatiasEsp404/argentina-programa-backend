package com.argentina.programa.mapper;

import com.argentina.programa.dto.response.InformationResponse;
import com.argentina.programa.model.InformationEntity;
import org.springframework.stereotype.Component;

@Component
public class InformationMapper {

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
        .build();

  }

}

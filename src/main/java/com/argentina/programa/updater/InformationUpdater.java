package com.argentina.programa.updater;

import org.springframework.stereotype.Component;
import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.model.InformationEntity;

@Component
public class InformationUpdater {

  public InformationEntity patch(InformationEntity entity, InformationRequest request) {

    if (request.getFirstName() != null && !request.getFirstName().isBlank()) {
      entity.setFirstName(request.getFirstName());
    }
    if (request.getLastName() != null && !request.getLastName().isBlank()) {
      entity.setLastName(request.getLastName());
    }
    if (request.getEmail() != null && !request.getEmail().isBlank()) {
      entity.setEmail(request.getEmail());
    }
    if (request.getPhoneNumber() != null && !request.getPhoneNumber().isBlank()) {
      entity.setPhoneNumber(request.getPhoneNumber());
    }
    if (request.getCountry() != null && !request.getCountry().isBlank()) {
      entity.setCountry(request.getCountry());
    }
    if (request.getProvince() != null && !request.getProvince().isBlank()) {
      entity.setProvince(request.getProvince());
    }
    if (request.getLocation() != null && !request.getLocation().isBlank()) {
      entity.setLocation(request.getLocation());
    }
    if (request.getLinkedin() != null && !request.getLinkedin().isBlank()) {
      entity.setLinkedin(request.getLinkedin());
    }
    if (request.getGitHub() != null && !request.getGitHub().isBlank()) {
      entity.setGitHub(request.getGitHub());
    }
    if (request.getSeniority() != null && !request.getSeniority().isBlank()) {
      entity.setSeniority(request.getSeniority());
    }
    if (request.getCoverImage() != null && !request.getCoverImage().isBlank()) {
      entity.setCoverImage(request.getCoverImage());
    }
    if (request.getProfilePicture() != null && !request.getProfilePicture().isBlank()) {
      entity.setProfilePicture(request.getProfilePicture());
    }
    return entity;

  }

}

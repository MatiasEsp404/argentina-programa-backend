package com.argentina.programa.updater;

import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.model.InformationEntity;
import org.springframework.stereotype.Component;

@Component
public class InformationUpdater {
  
  public InformationEntity patch(InformationEntity entity, InformationRequest request) {

    if (request.getFirstName() != null) {
      entity.setFirstName(request.getFirstName());
    }
    if (request.getLastName() != null) {
      entity.setLastName(request.getLastName());
    }
    if (request.getEmail() != null) {
      entity.setEmail(request.getEmail());
    }
    if (request.getPhoneNumber() != null) {
      entity.setPhoneNumber(request.getPhoneNumber());
    }
    if (request.getCountry() != null) {
      entity.setCountry(request.getCountry());
    }
    if (request.getProvince() != null) {
      entity.setProvince(request.getProvince());
    }
    if (request.getLocation() != null) {
      entity.setLocation(request.getLocation());
    }
    if (request.getLinkedin() != null) {
      entity.setLinkedin(request.getLinkedin());
    }
    if (request.getGitHub() != null) {
      entity.setGitHub(request.getGitHub());
    }
    if (request.getSeniority()!=null){
      entity.setSeniority(request.getSeniority());
    }
    if (request.getCoverImage()!=null){
      entity.setCoverImage(request.getCoverImage());
    }
    if (request.getProfilePicture()!=null){
      entity.setProfilePicture(request.getProfilePicture());
    }
    return entity;

  }

}

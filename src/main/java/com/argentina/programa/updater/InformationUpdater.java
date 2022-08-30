package com.argentina.programa.updater;

import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.model.InformationEntity;
import org.springframework.stereotype.Component;

@Component
public class InformationUpdater {

  public InformationEntity patch(InformationEntity original, InformationRequest update) {

    if (update.getFirstName() != null) {
      original.setFirstName(update.getFirstName());
    }
    if (update.getLastName() != null) {
      original.setLastName(update.getLastName());
    }
    if (update.getEmail() != null) {
      original.setEmail(update.getEmail());
    }
    if (update.getPhoneNumber() != null) {
      original.setPhoneNumber(update.getPhoneNumber());
    }
    if (update.getCountry() != null) {
      original.setCountry(update.getCountry());
    }
    if (update.getProvince() != null) {
      original.setProvince(update.getProvince());
    }
    if (update.getLocation() != null) {
      original.setLocation(update.getLocation());
    }
    if (update.getLinkedin() != null) {
      original.setLinkedin(update.getLinkedin());
    }
    if (update.getGitHub() != null) {
      original.setGitHub(update.getGitHub());
    }
    if (update.getSeniority()!=null){
      original.setSeniority(update.getSeniority());
    }
    if (update.getCoverImage()!=null){
      original.setCoverImage(update.getCoverImage());
    }
    if (update.getProfilePicture()!=null){
      original.setProfilePicture(update.getProfilePicture());
    }
    return original;

  }

}

package com.argentina.programa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationResponse {

  private String firstName;
  private String lastName;
  private String email;
  private String linkedin;
  private String gitHub;
  private String country;
  private String province;
  private String location;
  private String phoneNumber;
  private String seniority;
  private String profilePicture;
  private String coverImage;

}

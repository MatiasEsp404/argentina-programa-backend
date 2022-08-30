package com.argentina.programa.dto.request;

import com.argentina.programa.util.RegExpressionUtils;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationRequest {

  @Size(max = 20, message = "Maximum size for firstName is 20 characters.")
  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "firstName can only have alphabetic characters with spaces.")
  private String firstName;

  @Size(max = 20, message = "Maximum size for lastName is 20 characters.")
  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "lastName can only have alphabetic characters with spaces.")
  private String lastName;

  @Size(max = 100, message = "Maximum size for email is 100 characters.")
  @Email(message = "The email has invalid format.")
  private String email;

  @Size(max = 250, message = "Maximum size for linkedin is 250 characters.")
  //@Pattern(regexp = RegExpressionUtils.URL,
  // message = "The linkedin link has an invalid format.")
  private String linkedin;

  @Size(max = 250, message = "Maximum size for gitHub is 250 characters.")
  //@Pattern(regexp = RegExpressionUtils.URL,
  // message = "The gitHub link has an invalid format.")
  private String gitHub;

  @Size(max = 100, message = "Maximum size for direction is 100 characters.")
  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "country can only have alphabetic characters with spaces.")
  private String country;

  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "province can only have alphabetic characters with spaces.")
  private String province;

  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "location can only have alphabetic characters with spaces.")
  private String location;

  @Size(max = 20, message = "Maximum size for phoneNumber is 20 characters.")
  @Pattern(regexp = RegExpressionUtils.NUMERIC_CHARACTERS_WITHOUT_BLANK_SPACES,
      message = "phoneNumber can only have numeric characters with spaces.")
  private String phoneNumber;

  @Size(max = 50, message = "Maximum size for seniority is 50 characters.")
  @Pattern(regexp = RegExpressionUtils.ALPHABETIC_CHARACTERS_WITH_BLANK_SPACES,
      message = "seniority can only have alphabetic characters with spaces.")
  private String seniority;

  @Size(max = 250, message = "Maximum size for profilePicture is 250 characters.")
//  @Pattern(regexp = RegExpressionUtils.URL,
//  message = "The profilePicture link has an invalid format.")
  private String profilePicture;

  @Size(max = 250, message = "Maximum size for coverImage is 250 characters.")
//  @Pattern(regexp = RegExpressionUtils.URL,
//  message = "The coverImage link has an invalid format.")
  private String coverImage;

}

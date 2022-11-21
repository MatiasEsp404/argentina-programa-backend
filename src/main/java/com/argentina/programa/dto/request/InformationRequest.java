package com.argentina.programa.dto.request;

import com.argentina.programa.util.RegExpressionUtils;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationRequest {

  @Size(max = 20, message = "Maximum size for firstName is 20 characters.")
  private String firstName;

  @Size(max = 20, message = "Maximum size for lastName is 20 characters.")
  private String lastName;

  @Size(max = 100, message = "Maximum size for email is 100 characters.")
  @Email(message = "The email has invalid format.")
  private String email;

  @Size(max = 250, message = "Maximum size for linkedin is 250 characters.")
  private String linkedin;

  @Size(max = 250, message = "Maximum size for gitHub is 250 characters.")
  private String gitHub;

  @Size(max = 100, message = "Maximum size for direction is 100 characters.")
  private String country;

  private String province;

  private String location;

  @Size(max = 20, message = "Maximum size for phoneNumber is 20 characters.")
  @Pattern(regexp = RegExpressionUtils.NUMERIC_CHARACTERS_WITHOUT_BLANK_SPACES,
      message = "phoneNumber can only have numeric characters with spaces.")
  private String phoneNumber;

  @Size(max = 50, message = "Maximum size for seniority is 50 characters.")
  private String seniority;

  @Size(max = 250, message = "Maximum size for profilePicture is 250 characters.")
  private String profilePicture;

  @Size(max = 250, message = "Maximum size for coverImage is 250 characters.")
  private String coverImage;
  
  private List<FormationRequest> formations;
  
  private List<ProjectRequest> projects;

}

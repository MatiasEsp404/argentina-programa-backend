package com.argentina.programa.security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

  private int statusCode;
  private String message;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> moreInfo;

}

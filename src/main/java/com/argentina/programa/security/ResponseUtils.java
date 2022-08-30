package com.argentina.programa.security;

import com.argentina.programa.security.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ResponseUtils {

  private ResponseUtils() {
  }

  public static void setCustomForbiddenResponse(HttpServletResponse response) throws IOException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    ObjectMapper mapper = new ObjectMapper();
    response.getWriter().write(mapper.writeValueAsString(getGenericErrorResponse()));
  }

  private static ErrorResponse getGenericErrorResponse() {
    ErrorResponse response = new ErrorResponse();
    response.setStatusCode(HttpStatus.FORBIDDEN.value());
    response.setMessage("Access denied. Please, try to login again or contact your admin.");
    return response;
  }
}

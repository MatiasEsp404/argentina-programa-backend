package com.matias.argentinaprograma.config.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matias.argentinaprograma.config.security.common.ErrorResponse;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ResponseUtils {

	public static void setCustomForbiddenResponse(HttpServletResponse response) throws IOException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(getGenericErrorResponse()));
	}

	private static ErrorResponse getGenericErrorResponse() {
		return ErrorResponse.builder().statusCode(HttpStatus.FORBIDDEN.value())
				.message("Access denied. Please, try to login again or contact your admin.").build();
	}

}
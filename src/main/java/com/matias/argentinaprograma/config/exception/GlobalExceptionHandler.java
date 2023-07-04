package com.matias.argentinaprograma.config.exception;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.config.exception.runtime.InvalidCredentialsException;
import com.matias.argentinaprograma.config.exception.runtime.UserAlreadyExistException;
import com.matias.argentinaprograma.config.security.common.ErrorResponse;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = EntityNotFoundException.class)
  protected ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e) {
    ErrorResponse response = buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(),
        "Entidad no encontrada");
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = InvalidCredentialsException.class)
  protected ResponseEntity<ErrorResponse> handleInvalidCredentialsException(
      InvalidCredentialsException e) {
    ErrorResponse response = buildErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage(),
        "El servidor no puede devolver una respuesta debido a credenciales no válidas");
    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(value = UserAlreadyExistException.class)
  protected ResponseEntity<ErrorResponse> handleUserAlreadyExistException(
      UserAlreadyExistException e) {
    ErrorResponse response = buildErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
        "El servidor no pudo completar el registro del usuario porque la dirección de correo electrónico ingresada ya está en uso");
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  private ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message,
      List<String> moreInfo) {
    ErrorResponse response = new ErrorResponse();
    response.setStatusCode(httpStatus.value());
    response.setMessage(message);
    response.setMoreInfo(moreInfo);
    return response;
  }

  private ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message, String moreInfo) {
    return buildErrorResponse(httpStatus, message, Collections.singletonList(moreInfo));
  }

}

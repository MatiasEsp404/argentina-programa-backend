package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatosBasicosRequest {

  @Length(max = 64, message = "El nombre no debe superar los 64 caracteres")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @Length(max = 64, message = "El titulo no debe superar los 64 caracteres")
  @NotBlank(message = "El titulo no puede estar en blanco")
  private String titulo;

  @Length(max = 256, message = "El link de la imagen no debe superar los 256 caracteres")
  @NotBlank(message = "El link de la imagen no puede estar en blanco")
  private String imagen;

}

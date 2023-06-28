package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.NotBlank;
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
public class EstudioRequest {

  @Length(max = 64, message = "El titulo no debe superar los 64 caracteres")
  @NotBlank(message = "El titulo no puede estar en blanco")
  private String titulo;

  @Length(max = 12, message = "La fecha de finalizacion no puede superar los 12 caracteres")
  @NotBlank(message = "La fecha de finalizacion no puede estar en blanco")
  private String fechaFinalizacion;

  @Length(max = 256, message = "La descripcion no debe superar los 256 caracteres")
  @NotBlank(message = "La descripcion no puede estar en blanco")
  private String descripcion;

}

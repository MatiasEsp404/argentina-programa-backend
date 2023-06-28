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
public class TrabajoRequest {

  @Length(max = 64, message = "El titulo no puede superar los 64 caracteres")
  @NotBlank(message = "El titulo no puede estar en blanco")
  private String titulo;

  @Length(max = 64, message = "La empresa no puede superar los 64 caracteres")
  @NotBlank(message = "La empresa no puede estar en blanco")
  private String empresa;

  @Length(max = 12, message = "La fecha de contrato no puede superar los 12 caracteres")
  @NotBlank(message = "La fecha de contrato no puede estar en blanco")
  private String fechaDesde;

  @Length(max = 12, message = "La fecha de desvinculacion no puede superar los 12 caracteres")
  @NotBlank(message = "La fecha de desvinculacion no puede estar en blanco")
  private String fechaHasta;

  @Length(max = 256, message = "La descripcion no puede superar los 256 caracteres")
  @NotBlank(message = "La descripcion no puede estar en blanco")
  private String descripcion;

}
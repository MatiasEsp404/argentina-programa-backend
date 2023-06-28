package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class HabilidadRequest {

  @Length(max = 64, message = "El nombre no debe superar los 64 caracteres")
  @NotBlank(message = "El titulo no puede estar en blanco")
  private String nombre;

  @Min(value = 0, message = "La capacidad debe ser mayor a cero")
  @Max(value = 100, message = "La capacidad no puede ser mayor a 100")
  private Integer capacidad;

}

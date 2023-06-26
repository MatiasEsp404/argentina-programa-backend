package com.matias.argentinaprograma.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatosBasicosRequest {

  private String nombre;
  private String titulo;
  private String imagen;

}

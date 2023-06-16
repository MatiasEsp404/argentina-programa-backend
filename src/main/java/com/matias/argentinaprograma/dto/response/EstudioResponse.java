package com.matias.argentinaprograma.dto.response;

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
public class EstudioResponse {

  private Integer id;
  private String titulo;
  private String fechaFinalizacion;
  private String descripcion;

}

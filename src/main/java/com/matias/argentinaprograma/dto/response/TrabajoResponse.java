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
public class TrabajoResponse {

  private Integer id;
  private String titulo;
  private String empresa;
  private String fechaDesde;
  private String fechaHasta;
  private String descripcion;

}

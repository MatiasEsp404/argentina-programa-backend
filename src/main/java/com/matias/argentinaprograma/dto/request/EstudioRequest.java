package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getFechaFinalizacion() {
    return fechaFinalizacion;
  }

  public void setFechaFinalizacion(String fechaFinalizacion) {
    this.fechaFinalizacion = fechaFinalizacion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}

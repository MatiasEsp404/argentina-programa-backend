package com.matias.argentinaprograma.dto.request;

public class EstudioRequest {

  private String titulo;

  private String fechaFinalizacion;

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

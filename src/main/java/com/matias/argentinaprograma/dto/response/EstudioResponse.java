package com.matias.argentinaprograma.dto.response;

public class EstudioResponse {

  private Integer id;
  private String titulo;
  private String fechaFinalizacion;
  private String descripcion;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

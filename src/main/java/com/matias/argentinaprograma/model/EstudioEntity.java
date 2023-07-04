package com.matias.argentinaprograma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTUDIOS")
public class EstudioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_ESTUDIO")
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

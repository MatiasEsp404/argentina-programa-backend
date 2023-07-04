package com.matias.argentinaprograma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRABAJOS")
public class TrabajoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_TRABAJO")
  private Integer id;
  private String titulo;
  private String empresa;
  private String fechaDesde;
  private String fechaHasta;
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

  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public String getFechaDesde() {
    return fechaDesde;
  }

  public void setFechaDesde(String fechaDesde) {
    this.fechaDesde = fechaDesde;
  }

  public String getFechaHasta() {
    return fechaHasta;
  }

  public void setFechaHasta(String fechaHasta) {
    this.fechaHasta = fechaHasta;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}

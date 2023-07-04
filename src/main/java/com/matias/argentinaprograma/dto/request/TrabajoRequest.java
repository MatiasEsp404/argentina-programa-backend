package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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
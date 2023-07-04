package com.matias.argentinaprograma.dto.request;

public class HabilidadRequest {

  private String nombre;

  private Integer capacidad;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
  }
}

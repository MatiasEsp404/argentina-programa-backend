package com.matias.argentinaprograma.dto.request;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class DatosBasicosRequest {

  @Length(max = 64, message = "El nombre no debe superar los 64 caracteres")
  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @Length(max = 64, message = "El titulo no debe superar los 64 caracteres")
  @NotBlank(message = "El titulo no puede estar en blanco")
  private String titulo;

  @Length(max = 256, message = "El link de la imagen no debe superar los 256 caracteres")
  @NotBlank(message = "El link de la imagen no puede estar en blanco")
  private String imagen;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }
}

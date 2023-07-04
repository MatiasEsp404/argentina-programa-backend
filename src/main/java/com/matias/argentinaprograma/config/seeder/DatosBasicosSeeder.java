package com.matias.argentinaprograma.config.seeder;

import com.matias.argentinaprograma.model.DatosBasicosEntity;
import com.matias.argentinaprograma.repository.IDatosBasicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatosBasicosSeeder {

  @Autowired
  private IDatosBasicosRepository datosBasicosRepository;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    createDatosBasicos();
  }

  private void createDatosBasicos() {
    datosBasicosRepository.save(buildDatosBasicos());
  }

  private DatosBasicosEntity buildDatosBasicos() {
    DatosBasicosEntity entity = new DatosBasicosEntity();
    entity.setNombre("Claudio Matias Correa Espinola");
    entity.setTitulo("Desarrollador Java Full Stack");
    entity.setImagen("https://fotos.com/foto.png");
    return entity;
  }

}

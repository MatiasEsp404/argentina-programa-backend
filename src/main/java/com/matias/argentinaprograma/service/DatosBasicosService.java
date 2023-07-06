package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.model.DatosBasicosEntity;
import com.matias.argentinaprograma.repository.IDatosBasicosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosBasicosService {

  @Autowired
  private IDatosBasicosRepository datosBasicosRepository;

  public DatosBasicosEntity getBy(Integer id) {
    return findBy(id);
  }

  public DatosBasicosEntity update(DatosBasicosRequest request, Integer id) {
    verifyExistence(id);
    DatosBasicosEntity entity = toDatosBasicosEntity(request, id);
    return datosBasicosRepository.save(entity);
  }

  private DatosBasicosEntity toDatosBasicosEntity(DatosBasicosRequest request, Integer id) {
    DatosBasicosEntity entity = new DatosBasicosEntity();
    entity.setId(id);
    entity.setNombre(request.getNombre());
    entity.setTitulo(request.getTitulo());
    entity.setImagen(request.getImagen());
    return entity;
  }

  private void verifyExistence(Integer id) {
    if (!datosBasicosRepository.existsById(id)) {
      throw new EntityNotFoundException("Datos basicos no encontrados");
    }
  }

  private DatosBasicosEntity findBy(Integer id) {
    Optional<DatosBasicosEntity> entity = datosBasicosRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Datos basicos no encontrados");
    }
    return entity.get();
  }
}

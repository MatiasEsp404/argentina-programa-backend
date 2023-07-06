package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.model.EstudioEntity;
import org.springframework.stereotype.Component;

@Component
public class EstudioMapper {

  public EstudioEntity toEstudioEntity(EstudioRequest request) {
    EstudioEntity entity = new EstudioEntity();
    entity.setTitulo(request.getTitulo());
    entity.setDescripcion(request.getDescripcion());
    entity.setFechaFinalizacion(request.getFechaFinalizacion());
    return entity;
  }

  public EstudioEntity toEstudioEntity(EstudioRequest request, Integer id) {
    EstudioEntity entity = toEstudioEntity(request);
    entity.setId(id);
    return entity;
  }

}

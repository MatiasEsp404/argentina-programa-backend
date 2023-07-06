package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.model.HabilidadEntity;
import org.springframework.stereotype.Component;

@Component
public class HabilidadMapper {

  public HabilidadEntity toHabilidadEntity(HabilidadRequest request) {
    HabilidadEntity entity = new HabilidadEntity();
    entity.setNombre(request.getNombre());
    entity.setCapacidad(request.getCapacidad());
    return entity;
  }

  public HabilidadEntity toHabilidadEntity(HabilidadRequest request, Integer id) {
    HabilidadEntity entity = toHabilidadEntity(request);
    entity.setId(id);
    return entity;

  }

}

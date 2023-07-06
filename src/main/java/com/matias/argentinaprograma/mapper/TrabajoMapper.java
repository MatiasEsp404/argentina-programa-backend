package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.model.TrabajoEntity;
import org.springframework.stereotype.Component;

@Component
public class TrabajoMapper {

  public TrabajoEntity toTrabajoEntity(TrabajoRequest request) {
    TrabajoEntity entity = new TrabajoEntity();
    entity.setTitulo(request.getTitulo());
    entity.setEmpresa(request.getEmpresa());
    entity.setDescripcion(request.getDescripcion());
    entity.setFechaDesde(request.getFechaDesde());
    entity.setFechaHasta(request.getFechaHasta());
    return entity;
  }

  public TrabajoEntity toTrabajoEntity(TrabajoRequest request, Integer id) {
    TrabajoEntity entity = toTrabajoEntity(request);
    entity.setId(id);
    return entity;
  }

}

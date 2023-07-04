package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.model.TrabajoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TrabajoMapper {

  public List<TrabajoResponse> toTrabajoResponses(List<TrabajoEntity> trabajos) {
    List<TrabajoResponse> response = new ArrayList<>();
    for (TrabajoEntity trabajo : trabajos) {
      response.add(toTrabajoResponse(trabajo));
    }
    return response;
  }

  public TrabajoResponse toTrabajoResponse(TrabajoEntity trabajo) {
    TrabajoResponse response = new TrabajoResponse();
    response.setId(trabajo.getId());
    response.setTitulo(trabajo.getTitulo());
    response.setEmpresa(trabajo.getEmpresa());
    response.setDescripcion(trabajo.getDescripcion());
    response.setFechaDesde(trabajo.getFechaDesde());
    response.setFechaHasta(trabajo.getFechaHasta());
    return response;
  }

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

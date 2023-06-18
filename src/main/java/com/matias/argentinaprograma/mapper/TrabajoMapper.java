package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.model.TrabajoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TrabajoMapper {

  public List<TrabajoResponse> toTrabajoResponses(List<TrabajoEntity> trabajos){
    List<TrabajoResponse> response = new ArrayList<>();
    for(TrabajoEntity trabajo : trabajos){
      response.add(toTrabajoResponse(trabajo));
    }
    return response;
  }

  public TrabajoResponse toTrabajoResponse(TrabajoEntity trabajo){
    return TrabajoResponse.builder()
        .id(trabajo.getId())
        .titulo(trabajo.getTitulo())
        .descripcion(trabajo.getDescripcion())
        .fechaDesde(trabajo.getFechaDesde())
        .fechaHasta(trabajo.getFechaHasta())
        .build();
  }

  public List<TrabajoEntity> toTrabajoEntities(List<TrabajoRequest> requests) {
    List<TrabajoEntity> entities = new ArrayList<>();
    for (TrabajoRequest request : requests) {
      entities.add(toTrabajoEntity(request));
    }
    return entities;
  }

  public TrabajoEntity toTrabajoEntity(TrabajoRequest request) {
    return TrabajoEntity.builder()
        .titulo(request.getTitulo())
        .descripcion(request.getDescripcion())
        .fechaDesde(request.getFechaDesde())
        .fechaHasta(request.getFechaHasta())
        .build();
  }

}

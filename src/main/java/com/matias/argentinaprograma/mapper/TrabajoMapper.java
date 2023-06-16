package com.matias.argentinaprograma.mapper;

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

}

package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.dto.response.EstudioResponse;
import com.matias.argentinaprograma.model.EstudioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EstudioMapper {

  public List<EstudioResponse> toEstudioResponses(List<EstudioEntity> estudios) {
    List<EstudioResponse> responses = new ArrayList<>();
    for (EstudioEntity estudio : estudios) {
      responses.add(toEstudioResponse(estudio));
    }
    return responses;
  }

  public EstudioResponse toEstudioResponse(EstudioEntity estudio) {
    return EstudioResponse.builder()
        .id(estudio.getId())
        .titulo(estudio.getTitulo())
        .descripcion(estudio.getDescripcion())
        .fechaFinalizacion(estudio.getFechaFinalizacion())
        .build();
  }

  public List<EstudioEntity> toEstudioEntities(List<EstudioRequest> requests) {
    List<EstudioEntity> entities = new ArrayList<>();
    for (EstudioRequest request : requests) {
      entities.add(toEstudioEntity(request));
    }
    return entities;
  }

  public EstudioEntity toEstudioEntity(EstudioRequest request) {
    return EstudioEntity.builder()
        .titulo(request.getTitulo())
        .descripcion(request.getDescripcion())
        .fechaFinalizacion(request.getFechaFinalizacion())
        .build();
  }

}

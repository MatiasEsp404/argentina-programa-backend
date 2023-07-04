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
    EstudioResponse response = new EstudioResponse();
    response.setId(estudio.getId());
    response.setTitulo(estudio.getTitulo());
    response.setDescripcion(estudio.getDescripcion());
    response.setFechaFinalizacion(estudio.getFechaFinalizacion());
    return response;
  }

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

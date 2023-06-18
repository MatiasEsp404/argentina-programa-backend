package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import com.matias.argentinaprograma.model.HabilidadEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HabilidadMapper {

  public List<HabilidadResponse> toHabilidadResponses(List<HabilidadEntity> habilidades) {
    List<HabilidadResponse> response = new ArrayList<>();
    for (HabilidadEntity habilidad : habilidades) {
      response.add(toHabilidadResponse(habilidad));
    }
    return response;
  }

  public HabilidadResponse toHabilidadResponse(HabilidadEntity habilidad) {
    return HabilidadResponse.builder()
        .id(habilidad.getId())
        .capacidad(habilidad.getCapacidad())
        .nombre(habilidad.getNombre())
        .build();
  }

  public List<HabilidadEntity> toHabilidadEntities(List<HabilidadRequest> requests) {
    List<HabilidadEntity> entities = new ArrayList<>();
    for(HabilidadRequest request : requests) {
      entities.add(toHabilidadEntity(request));
    }
    return entities;
  }

  public HabilidadEntity toHabilidadEntity(HabilidadRequest request) {
    return HabilidadEntity.builder()
        .nombre(request.getNombre())
        .capacidad(request.getCapacidad())
        .build();
  }

}

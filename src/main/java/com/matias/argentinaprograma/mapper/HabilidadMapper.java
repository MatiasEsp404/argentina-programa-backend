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
    HabilidadResponse response = new HabilidadResponse();
    response.setId(habilidad.getId());
    response.setCapacidad(habilidad.getCapacidad());
    response.setNombre(habilidad.getNombre());
    return response;
  }

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

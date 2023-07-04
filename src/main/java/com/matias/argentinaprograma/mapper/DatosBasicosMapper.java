package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.dto.response.DatosBasicosResponse;
import com.matias.argentinaprograma.model.DatosBasicosEntity;
import org.springframework.stereotype.Component;

@Component
public class DatosBasicosMapper {

  public DatosBasicosEntity toDatosBasicosEntity(DatosBasicosRequest request, Integer id) {
    DatosBasicosEntity entity = new DatosBasicosEntity();
    entity.setId(id);
    entity.setNombre(request.getNombre());
    entity.setTitulo(request.getTitulo());
    entity.setImagen(request.getImagen());
    return entity;
  }

  public DatosBasicosResponse toDatosBasicosResponse(DatosBasicosEntity entity) {
    DatosBasicosResponse response = new DatosBasicosResponse();
    response.setId(entity.getId());
    response.setNombre(entity.getNombre());
    response.setTitulo(entity.getTitulo());
    response.setImagen(entity.getImagen());
    return response;
  }

}

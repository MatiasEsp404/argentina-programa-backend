package com.matias.argentinaprograma.mapper;

import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.dto.response.DatosBasicosResponse;
import com.matias.argentinaprograma.model.DatosBasicosEntity;
import org.springframework.stereotype.Component;

@Component
public class DatosBasicosMapper {

  public DatosBasicosEntity toDatosBasicosEntity(DatosBasicosRequest request, Integer id) {
    return DatosBasicosEntity.builder()
        .id(id)
        .nombre(request.getNombre())
        .titulo(request.getTitulo())
        .imagen(request.getImagen())
        .build();
  }

  public DatosBasicosResponse toDatosBasicosResponse(DatosBasicosEntity entity) {
    return DatosBasicosResponse.builder()
        .id(entity.getId())
        .nombre(entity.getNombre())
        .titulo(entity.getTitulo())
        .imagen(entity.getImagen())
        .build();
  }

}

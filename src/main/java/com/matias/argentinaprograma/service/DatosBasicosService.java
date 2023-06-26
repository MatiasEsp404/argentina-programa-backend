package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.dto.response.DatosBasicosResponse;
import com.matias.argentinaprograma.mapper.DatosBasicosMapper;
import com.matias.argentinaprograma.model.DatosBasicosEntity;
import com.matias.argentinaprograma.repository.IDatosBasicosRepository;
import com.matias.argentinaprograma.service.abstraction.IDatosBasicosService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosBasicosService implements IDatosBasicosService {

  @Autowired
  private IDatosBasicosRepository datosBasicosRepository;

  @Autowired
  private DatosBasicosMapper datosBasicosMapper;

  @Override
  public DatosBasicosResponse getBy(Integer id) {
    return datosBasicosMapper.toDatosBasicosResponse(findBy(id));
  }

  @Override
  public DatosBasicosResponse update(DatosBasicosRequest request, Integer id) {
    verifyExistence(id);
    DatosBasicosEntity entity = datosBasicosMapper.toDatosBasicosEntity(request, id);
    return datosBasicosMapper.toDatosBasicosResponse(datosBasicosRepository.save(entity));
  }

  private void verifyExistence(Integer id) {
    if (!datosBasicosRepository.existsById(id)) {
      throw new EntityNotFoundException("Datos basicos no encontrados");
    }
  }

  private DatosBasicosEntity findBy(Integer id) {
    Optional<DatosBasicosEntity> entity = datosBasicosRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Datos basicos no encontrados");
    }
    return entity.get();
  }
}

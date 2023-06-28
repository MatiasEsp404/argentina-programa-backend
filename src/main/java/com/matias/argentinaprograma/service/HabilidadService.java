package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import com.matias.argentinaprograma.mapper.HabilidadMapper;
import com.matias.argentinaprograma.model.HabilidadEntity;
import com.matias.argentinaprograma.repository.IHabilidadRepository;
import com.matias.argentinaprograma.service.abstraction.IHabilidadService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {

  @Autowired
  private IHabilidadRepository habilidadRepository;

  @Autowired
  private HabilidadMapper habilidadMapper;

  @Override
  public List<HabilidadResponse> getAll() {
    return habilidadMapper.toHabilidadResponses(habilidadRepository.findAll());
  }

  @Override
  public HabilidadResponse getBy(Integer id) {
    return habilidadMapper.toHabilidadResponse(findBy(id));
  }

  @Override
  public HabilidadResponse create(HabilidadRequest request) {
    HabilidadEntity entity = habilidadMapper.toHabilidadEntity(request);
    return habilidadMapper.toHabilidadResponse(habilidadRepository.save(entity));
  }

  @Override
  public HabilidadResponse update(Integer id, HabilidadRequest request) {
    verifyExistence(id);
    HabilidadEntity entity = habilidadMapper.toHabilidadEntity(request, id);
    return habilidadMapper.toHabilidadResponse(habilidadRepository.save(entity));
  }

  @Override
  public void delete(Integer id) {
    verifyExistence(id);
    habilidadRepository.deleteById(id);
  }

  private void verifyExistence(Integer id) {
    if (!habilidadRepository.existsById(id)) {
      throw new EntityNotFoundException("Habilidad no encontrada");
    }
  }

  private HabilidadEntity findBy(Integer id) {
    Optional<HabilidadEntity> entity = habilidadRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Habilidad no encontrada");
    }
    return entity.get();
  }
}

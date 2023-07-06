package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.mapper.HabilidadMapper;
import com.matias.argentinaprograma.model.HabilidadEntity;
import com.matias.argentinaprograma.repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService {

  @Autowired
  private IHabilidadRepository habilidadRepository;

  @Autowired
  private HabilidadMapper habilidadMapper;

  public List<HabilidadEntity> getAll() {
    return habilidadRepository.findAll();
  }

  public HabilidadEntity getBy(Integer id) {
    return findBy(id);
  }

  public HabilidadEntity create(HabilidadRequest request) {
    HabilidadEntity entity = habilidadMapper.toHabilidadEntity(request);
    return habilidadRepository.save(entity);
  }

  public HabilidadEntity update(Integer id, HabilidadRequest request) {
    verifyExistence(id);
    HabilidadEntity entity = habilidadMapper.toHabilidadEntity(request, id);
    return habilidadRepository.save(entity);
  }

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

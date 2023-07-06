package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.mapper.TrabajoMapper;
import com.matias.argentinaprograma.model.TrabajoEntity;
import com.matias.argentinaprograma.repository.ITrabajoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService {

  @Autowired
  private ITrabajoRepository trabajoRepository;

  @Autowired
  private TrabajoMapper trabajoMapper;

  public List<TrabajoEntity> getAll() {
    return trabajoRepository.findAll();
  }

  public TrabajoEntity getBy(Integer id) {
    return findBy(id);
  }

  public TrabajoEntity create(TrabajoRequest request) {
    TrabajoEntity entity = trabajoMapper.toTrabajoEntity(request);
    return trabajoRepository.save(entity);
  }

  public TrabajoEntity update(Integer id, TrabajoRequest request) {
    verifyExistence(id);
    TrabajoEntity entity = trabajoMapper.toTrabajoEntity(request, id);
    return trabajoRepository.save(entity);
  }

  public void delete(Integer id) {
    verifyExistence(id);
    trabajoRepository.deleteById(id);
  }

  private void verifyExistence(Integer id) {
    if (!trabajoRepository.existsById(id)) {
      throw new EntityNotFoundException("Trabajo no encontrado");
    }
  }

  private TrabajoEntity findBy(Integer id) {
    Optional<TrabajoEntity> entity = trabajoRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Trabajo no encontrado");
    }
    return entity.get();
  }
}

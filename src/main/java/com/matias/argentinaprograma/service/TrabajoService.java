package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.mapper.TrabajoMapper;
import com.matias.argentinaprograma.model.TrabajoEntity;
import com.matias.argentinaprograma.repository.ITrabajoRepository;
import com.matias.argentinaprograma.service.abstraction.ITrabajoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService implements ITrabajoService {

  @Autowired
  private ITrabajoRepository trabajoRepository;

  @Autowired
  private TrabajoMapper trabajoMapper;

  @Override
  public List<TrabajoResponse> getAll() {
    return trabajoMapper.toTrabajoResponses(trabajoRepository.findAll());
  }

  @Override
  public TrabajoResponse getById(Integer id) {
    return null;
  }

  @Override
  public TrabajoResponse create(TrabajoRequest request) {
    return null;
  }

  @Override
  public TrabajoResponse update(Integer id, TrabajoRequest request) {
    return null;
  }

  @Override
  public void delete(Integer id) {

  }

  private void verifyExistence(Integer id) {
    if (!trabajoRepository.existsById(id)) {
      throw new EntityNotFoundException("Habilidad no encontrada");
    }
  }

  private TrabajoEntity findBy(Integer id) {
    Optional<TrabajoEntity> entity = trabajoRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Habilidad no encontrada");
    }
    return entity.get();
  }
}

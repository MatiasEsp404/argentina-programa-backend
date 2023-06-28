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
  public TrabajoResponse getBy(Integer id) {
    return trabajoMapper.toTrabajoResponse(findBy(id));
  }

  @Override
  public TrabajoResponse create(TrabajoRequest request) {
    TrabajoEntity entity = trabajoMapper.toTrabajoEntity(request);
    return trabajoMapper.toTrabajoResponse(trabajoRepository.save(entity));
  }

  @Override
  public TrabajoResponse update(Integer id, TrabajoRequest request) {
    verifyExistence(id);
    TrabajoEntity entity = trabajoMapper.toTrabajoEntity(request, id);
    return trabajoMapper.toTrabajoResponse(trabajoRepository.save(entity));
  }

  @Override
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

package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.dto.response.EstudioResponse;
import com.matias.argentinaprograma.mapper.EstudioMapper;
import com.matias.argentinaprograma.model.EstudioEntity;
import com.matias.argentinaprograma.repository.IEstudioRepository;
import com.matias.argentinaprograma.service.abstraction.IEstudioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService {

  @Autowired
  private IEstudioRepository estudioRepository;

  @Autowired
  private EstudioMapper estudioMapper;

  @Override
  public List<EstudioResponse> getAll() {
    return estudioMapper.toEstudioResponses(estudioRepository.findAll());
  }

  @Override
  public EstudioResponse getBy(Integer id) {
    return estudioMapper.toEstudioResponse(findBy(id));
  }

  @Override
  public EstudioResponse create(EstudioRequest request) {
    EstudioEntity entity = estudioMapper.toEstudioEntity(request);
    return estudioMapper.toEstudioResponse(estudioRepository.save(entity));
  }

  @Override
  public EstudioResponse update(Integer id, EstudioRequest request) {
    verifyExistence(id);
    EstudioEntity entity = estudioMapper.toEstudioEntity(request, id);
    return estudioMapper.toEstudioResponse(estudioRepository.save(entity));
  }

  @Override
  public void delete(Integer id) {
    verifyExistence(id);
    estudioRepository.deleteById(id);
  }

  private void verifyExistence(Integer id) {
    if (!estudioRepository.existsById(id)) {
      throw new EntityNotFoundException("Estudio no encontrado");
    }
  }

  private EstudioEntity findBy(Integer id) {
    Optional<EstudioEntity> entity = estudioRepository.findById(id);
    if (!entity.isPresent()) {
      throw new EntityNotFoundException("Estudio no encontrado");
    }
    return entity.get();
  }

}

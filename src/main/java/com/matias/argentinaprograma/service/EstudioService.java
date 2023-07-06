package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.config.exception.runtime.EntityNotFoundException;
import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.mapper.EstudioMapper;
import com.matias.argentinaprograma.model.EstudioEntity;
import com.matias.argentinaprograma.repository.IEstudioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService {

  @Autowired
  private IEstudioRepository estudioRepository;

  @Autowired
  private EstudioMapper estudioMapper;

  public List<EstudioEntity> getAll() {
    return estudioRepository.findAll();
  }

  public EstudioEntity getBy(Integer id) {
    return findBy(id);
  }

  public EstudioEntity create(EstudioRequest request) {
    EstudioEntity entity = estudioMapper.toEstudioEntity(request);
    return estudioRepository.save(entity);
  }

  public EstudioEntity update(Integer id, EstudioRequest request) {
    verifyExistence(id);
    EstudioEntity entity = estudioMapper.toEstudioEntity(request, id);
    return estudioRepository.save(entity);
  }

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

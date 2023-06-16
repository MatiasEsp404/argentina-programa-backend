package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.dto.response.EstudioResponse;
import com.matias.argentinaprograma.mapper.EstudioMapper;
import com.matias.argentinaprograma.repository.IEstudioRepository;
import com.matias.argentinaprograma.service.abstraction.IEstudioService;
import java.util.List;
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

}

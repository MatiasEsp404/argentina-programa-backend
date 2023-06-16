package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import com.matias.argentinaprograma.mapper.TrabajoMapper;
import com.matias.argentinaprograma.repository.ITrabajoRepository;
import com.matias.argentinaprograma.service.abstraction.ITrabajoService;
import java.util.List;
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
}

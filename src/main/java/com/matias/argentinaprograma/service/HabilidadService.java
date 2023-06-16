package com.matias.argentinaprograma.service;

import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import com.matias.argentinaprograma.mapper.HabilidadMapper;
import com.matias.argentinaprograma.repository.IHabilidadRepository;
import com.matias.argentinaprograma.service.abstraction.IHabilidadService;
import java.util.List;
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
}

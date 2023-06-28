package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.HabilidadRequest;
import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import java.util.List;

public interface IHabilidadService {

  List<HabilidadResponse> getAll();

  HabilidadResponse getBy(Integer id);

  HabilidadResponse create(HabilidadRequest request);

  HabilidadResponse update(Integer id, HabilidadRequest request);

  void delete(Integer id);
}

package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.TrabajoRequest;
import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import java.util.List;

public interface ITrabajoService {

  List<TrabajoResponse> getAll();

  TrabajoResponse getById(Integer id);

  TrabajoResponse create(TrabajoRequest request);

  TrabajoResponse update(Integer id, TrabajoRequest request);

  void delete(Integer id);
}

package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.EstudioRequest;
import com.matias.argentinaprograma.dto.response.EstudioResponse;
import java.util.List;

public interface IEstudioService {

  List<EstudioResponse> getAll();

  EstudioResponse getById(Integer id);

  EstudioResponse create(EstudioRequest request);

  EstudioResponse update(Integer id, EstudioRequest request);

  void delete(Integer id);
}

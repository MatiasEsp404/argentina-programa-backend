package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.response.TrabajoResponse;
import java.util.List;

public interface ITrabajoService {

  List<TrabajoResponse> getAll();

}

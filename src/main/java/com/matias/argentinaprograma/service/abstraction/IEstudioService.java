package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.response.EstudioResponse;
import java.util.List;

public interface IEstudioService {

  List<EstudioResponse> getAll();

}

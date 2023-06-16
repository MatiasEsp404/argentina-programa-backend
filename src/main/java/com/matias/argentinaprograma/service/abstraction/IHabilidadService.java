package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.response.HabilidadResponse;
import java.util.List;

public interface IHabilidadService {

  List<HabilidadResponse> getAll();

}

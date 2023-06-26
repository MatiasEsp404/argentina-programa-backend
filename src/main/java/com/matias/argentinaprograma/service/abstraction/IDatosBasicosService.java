package com.matias.argentinaprograma.service.abstraction;

import com.matias.argentinaprograma.dto.request.DatosBasicosRequest;
import com.matias.argentinaprograma.dto.response.DatosBasicosResponse;

public interface IDatosBasicosService {

  DatosBasicosResponse getBy(Integer id);

  DatosBasicosResponse update(DatosBasicosRequest request, Integer id);

}

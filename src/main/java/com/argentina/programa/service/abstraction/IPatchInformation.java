package com.argentina.programa.service.abstraction;

import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.dto.response.InformationResponse;

public interface IPatchInformation {

  InformationResponse patch(InformationRequest informationRequest);

}

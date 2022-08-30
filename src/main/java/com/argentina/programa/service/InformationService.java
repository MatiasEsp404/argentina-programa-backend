package com.argentina.programa.service;

import com.argentina.programa.dto.request.InformationRequest;
import com.argentina.programa.dto.response.InformationResponse;
import com.argentina.programa.exception.EntityNotFoundException;
import com.argentina.programa.mapper.InformationMapper;
import com.argentina.programa.model.InformationEntity;
import com.argentina.programa.repository.IInformationRepository;
import com.argentina.programa.service.abstraction.IGetInformation;
import com.argentina.programa.service.abstraction.IPatchInformation;
import com.argentina.programa.updater.InformationUpdater;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService implements IGetInformation, IPatchInformation {

  @Autowired
  private IInformationRepository informationRepository;

  @Autowired
  private InformationMapper informationMapper;

  @Autowired
  private InformationUpdater informationUpdater;

  @Override
  public InformationResponse get() {
    return informationMapper.toInformationResponse(getBasicInformation());
  }

  private InformationEntity getBasicInformation() {
    Optional<InformationEntity> optionalInformation = informationRepository.findById(1L);
    if (optionalInformation.isEmpty()) {
      throw new EntityNotFoundException("Basic information not found.");
    }
    return optionalInformation.get();
  }

  @Override
  public InformationResponse patch(InformationRequest informationRequest) {
    InformationEntity information = getBasicInformation();
    information = informationUpdater.patch(information, informationRequest);
    information = informationRepository.save(information);
    return informationMapper.toInformationResponse(information);
  }
}

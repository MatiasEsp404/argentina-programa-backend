package com.argentina.programa.repository;

import com.argentina.programa.model.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformationRepository extends JpaRepository<InformationEntity, Long> {

}

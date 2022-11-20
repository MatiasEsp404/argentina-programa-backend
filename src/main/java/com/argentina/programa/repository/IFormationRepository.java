package com.argentina.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.argentina.programa.model.FormationEntity;

@Repository
public interface IFormationRepository extends JpaRepository<FormationEntity, Integer> {
 
}

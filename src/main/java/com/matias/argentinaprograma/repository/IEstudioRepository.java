package com.matias.argentinaprograma.repository;

import com.matias.argentinaprograma.model.EstudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepository extends JpaRepository<EstudioEntity, Integer> {

}

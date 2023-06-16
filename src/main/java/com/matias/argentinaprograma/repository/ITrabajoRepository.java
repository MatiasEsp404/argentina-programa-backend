package com.matias.argentinaprograma.repository;

import com.matias.argentinaprograma.model.TrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajoRepository extends JpaRepository<TrabajoEntity, Integer> {

}

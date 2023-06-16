package com.matias.argentinaprograma.repository;

import com.matias.argentinaprograma.model.HabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<HabilidadEntity, Integer> {

}

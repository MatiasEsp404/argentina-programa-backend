package com.matias.argentinaprograma.repository;

import com.matias.argentinaprograma.model.DatosBasicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDatosBasicosRepository extends JpaRepository<DatosBasicosEntity, Integer> {

}

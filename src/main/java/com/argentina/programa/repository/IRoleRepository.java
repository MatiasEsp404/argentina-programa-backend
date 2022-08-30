package com.argentina.programa.repository;

import com.argentina.programa.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

  RoleEntity findByName(String name);

}

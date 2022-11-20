package com.argentina.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.argentina.programa.model.ProjectEntity;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectEntity, Integer>{

}

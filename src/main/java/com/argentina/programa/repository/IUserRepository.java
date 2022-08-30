package com.argentina.programa.repository;

import com.argentina.programa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);


}

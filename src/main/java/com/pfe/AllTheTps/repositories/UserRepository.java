package com.pfe.AllTheTps.repositories;


import com.pfe.AllTheTps.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends
        JpaRepository<UserEntity, Long> {
}

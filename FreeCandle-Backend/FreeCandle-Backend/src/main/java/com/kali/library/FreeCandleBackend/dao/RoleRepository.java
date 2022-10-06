package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.ERole;
import com.kali.library.FreeCandleBackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

     static Optional<Role> findByName(ERole name) {
          return null;
     }
}

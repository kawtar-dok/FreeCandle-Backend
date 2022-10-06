package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findByUsername(String username);
    List<Admin> findByUsernameAndPassword(String username, String password);
}

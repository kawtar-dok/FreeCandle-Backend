package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUsername(String username);

    List<User> findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}

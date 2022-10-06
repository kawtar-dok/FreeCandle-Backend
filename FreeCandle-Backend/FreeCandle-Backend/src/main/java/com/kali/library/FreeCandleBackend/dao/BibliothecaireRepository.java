package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Bibliothecaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliothecaireRepository extends JpaRepository<Bibliothecaire,Long> {
    List<Bibliothecaire> findByUsername(String username);
    List<Bibliothecaire> findByUsernameAndPassword(String username,String password);
}

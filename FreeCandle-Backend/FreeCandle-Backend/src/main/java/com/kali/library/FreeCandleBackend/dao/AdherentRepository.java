package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Adherent;
import com.kali.library.FreeCandleBackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdherentRepository extends JpaRepository<Adherent,Long> {
    List<Adherent> findByUsername(String username);
    List<Adherent> findByFirstname(String firstname);
    List<Adherent> findByLastname(String lastname);
}

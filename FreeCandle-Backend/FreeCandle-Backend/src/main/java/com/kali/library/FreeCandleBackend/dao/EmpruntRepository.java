package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {

    List<Emprunt> findByStatus(String status);
    List<Emprunt> findByIdAndPrice(Long idEmprunt, String price);







}

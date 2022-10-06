package com.kali.library.FreeCandleBackend.dao;

import com.kali.library.FreeCandleBackend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section,Long> {
    List<Section> findByName(String name);
    @Query("select s from Section s where s.name = ?1 and s.theme = ?2")
    List<Section> findByNameAndTheme(String name, String theme);
    List<Section> findByTheme(String theme);
    List<Section> findByLanguage(String language);
}

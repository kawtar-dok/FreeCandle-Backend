package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.BibliothecaireRepository;
import com.kali.library.FreeCandleBackend.model.Bibliothecaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BibliothecaireController {
    @Autowired
    private BibliothecaireRepository bibliothecaireRepository;

    @GetMapping(path="/index")
    public String bibliothecaire(Model model){
        List<Bibliothecaire> bibliothecaire = bibliothecaireRepository.findAll();
        model.addAttribute("ListBibliothecaire",bibliothecaire);
        return "Bibliothecaire";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        bibliothecaireRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}

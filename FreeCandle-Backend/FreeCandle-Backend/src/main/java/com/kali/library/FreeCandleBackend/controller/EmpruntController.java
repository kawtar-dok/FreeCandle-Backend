package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.EmpruntRepository;
import com.kali.library.FreeCandleBackend.dao.UserRepository;
import com.kali.library.FreeCandleBackend.model.Emprunt;
import com.kali.library.FreeCandleBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class EmpruntController {
    @Autowired
    private EmpruntRepository empruntRepository;


    @GetMapping(path="/index")
    public String emprunts(Model model){
        List<Emprunt> emprunts = empruntRepository.findAll();
        model.addAttribute("ListEmprunt",emprunts);
        return "emprunt";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        empruntRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

}

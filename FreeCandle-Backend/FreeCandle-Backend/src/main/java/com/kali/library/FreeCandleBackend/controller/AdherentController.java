package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.AdherentRepository;
import com.kali.library.FreeCandleBackend.dao.BookRepository;
import com.kali.library.FreeCandleBackend.model.Adherent;
import com.kali.library.FreeCandleBackend.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AdherentController {

    @Autowired
    private AdherentRepository adherentRepository;

    @GetMapping(path="/index")
    public String adherent(Model model){
        List<Adherent> adherents = adherentRepository.findAll();
        model.addAttribute("ListAdherent",adherents);
        return "adherents";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        adherentRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }


}

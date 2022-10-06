package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.BookRepository;
import com.kali.library.FreeCandleBackend.dao.SectionRepository;
import com.kali.library.FreeCandleBackend.model.Book;
import com.kali.library.FreeCandleBackend.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class SectionController {
    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping(path="/index")
    public String sections(Model model){
        List<Section> sections = sectionRepository.findAll();
        model.addAttribute("ListSection",sections);
        return "section";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        sectionRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

}

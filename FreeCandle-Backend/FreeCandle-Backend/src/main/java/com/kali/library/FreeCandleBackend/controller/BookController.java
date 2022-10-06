package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.BookRepository;
import com.kali.library.FreeCandleBackend.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/index")
    public String books(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("ListBooks",books);
        return "books";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        bookRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }


}

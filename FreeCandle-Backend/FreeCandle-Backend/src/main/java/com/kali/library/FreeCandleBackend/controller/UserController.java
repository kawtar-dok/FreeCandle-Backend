package com.kali.library.FreeCandleBackend.controller;


import com.kali.library.FreeCandleBackend.dao.UserRepository;

import com.kali.library.FreeCandleBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(path="/index")
    public String users(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("ListUsers",users);
        return "users";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        userRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

}

package com.kali.library.FreeCandleBackend.controller;

import com.kali.library.FreeCandleBackend.dao.AdminRepository;
import com.kali.library.FreeCandleBackend.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(path="/index")
    public String admins(Model model){
        List<Admin> admins = adminRepository.findAll();
        model.addAttribute("ListAdmin",admins);
        return "admin";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        adminRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

}

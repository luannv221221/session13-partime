package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model){
        String fullName = "Phan Kim Liên";
        model.addAttribute("fullName",fullName);
        return "home";
    }
}

package com.example.carrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/home")
public class HomeController {

    @GetMapping("/home/welcome")
    public String home(Model model) {
        return "home";
    }

}

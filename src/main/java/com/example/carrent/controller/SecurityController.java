package com.example.carrent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/logged")
    public String welcome(Model model) {
        return "logged";
    }

    @GetMapping("/errlogged")
    public String loginError(Model model) {
        return "loginError";
    }

}

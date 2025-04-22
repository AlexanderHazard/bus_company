package com.example.carrent.controller;

import com.example.carrent.dao.UserRepository;
import com.example.carrent.dao.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "/admin")
public class AdminController {

    @Autowired
    private UserRepository carRepository;

    @GetMapping("/admin/allAccounts")
    public String getAllCars(Model model) {
        List<User> users = carRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("deleteUser", new User());
        return "admin";
    }

}

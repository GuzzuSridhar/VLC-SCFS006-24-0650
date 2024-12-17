package com.example.securityjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String showRoot() {
        return "welcome";
    }

    @PostMapping("/")
    public String showRoot1() {
        return "welcome";
    }
}

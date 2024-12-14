package com.example.securitycustom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecController {
    @GetMapping("/")
    public String showmain() {
        return "welcome";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/sample")
    public String show() {
        return "sample";
    }
}

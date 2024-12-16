package com.example.securitycustom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecController {
    @GetMapping("/")
    public String showmain() {
        return "welcome";
    }

    @PostMapping("/home")
    public String showmainO() {
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

    @GetMapping("/403")
    public String showAd() {
        return "403";
    }
}

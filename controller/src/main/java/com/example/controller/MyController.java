package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String showMain() {
        return "Hello"; // not the Spring container looks for a template called Hello.
    }

    @RequestMapping("/test")
    public String showTest() {
        return "test"; // not the Spring container looks for a template called Hello.
    }
}

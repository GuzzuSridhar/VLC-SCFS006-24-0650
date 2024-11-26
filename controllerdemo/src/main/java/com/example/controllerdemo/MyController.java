package com.example.controllerdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/")
    public String showRoot() {
        return "Welcome to Spring Boot with VSCode";
    }

    @RequestMapping("/test")
    public String showTest() {
        return "This is another end point";
    }

}

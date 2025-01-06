package com.example.undertowdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UndertowController {
    @GetMapping("/")
    public String showMain() {
        return "Hello UnderTow";
    }
}

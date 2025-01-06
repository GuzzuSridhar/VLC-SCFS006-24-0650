package com.example.jettydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JettyController {
    @GetMapping("/")
    public String testJetty() {
        return "Hello Jetty";
    }
}

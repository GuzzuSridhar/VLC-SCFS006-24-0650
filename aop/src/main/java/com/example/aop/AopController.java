package com.example.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    @GetMapping("/operation")
    public String performOperation() {
        return "Operation performed!";
    }

    @GetMapping("/another")
    public String anotherMethod() {
        return "Another method executed!";
    }
}

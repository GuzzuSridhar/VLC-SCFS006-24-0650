package com.example.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String showMain() {
        return "index";
    }

    @RequestMapping("/withdraw/{amt}")
    public String withdrawAmt(@PathVariable("amt") float amt) {
        System.out.println("Hello");
        return "success";
    }
}

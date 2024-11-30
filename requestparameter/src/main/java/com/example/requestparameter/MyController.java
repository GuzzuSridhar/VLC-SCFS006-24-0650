package com.example.requestparameter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/add")
    public double add(@RequestParam(name = "n1") double x, @RequestParam(value = "n2") double y) {
        return x + y;
    }
}

package com.example.pathvariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/square/{num}")
    public double getSquare(@PathVariable("num") double x) {
        return Math.pow(x, 2);
    }
}

// to access the square use
// http://localhost:8080/square/10

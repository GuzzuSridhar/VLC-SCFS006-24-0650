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

    @RequestMapping("/subtract")
    public double subtract(@RequestParam(name = "n1", defaultValue = "10") double x,
            @RequestParam(value = "n2", defaultValue = "20") double y) {
        return x - y;
    }

    @RequestMapping("/prod")
    public double prod(@RequestParam(name = "n1", defaultValue = "10", required = false) double x,
            @RequestParam(value = "n2", defaultValue = "20", required = false) double y) {
        return x * y;
    }
}

// @RequestParam can take 3 arguments
/*
 * name/value is used name the paramaters
 * defaultValue to assign the default value to a parameter (defaultValue when
 * mentioned makes the required false implicitly)
 * required by default is true
 */
package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalcController {
    @RequestMapping("/add")
    public String add(int n1, int n2, String choice, Model model) {
        int res = 0;
        if (choice.equalsIgnoreCase("add"))
            res = n1 + n2;
        else if (choice.equalsIgnoreCase("subtract"))
            res = n1 - n2;
        else if (choice.equalsIgnoreCase("multiply"))
            res = n1 * n2;
        else if (choice.equalsIgnoreCase("divide"))
            res = n1 / n2;
        model.addAttribute("result", res);
        return "calc";
    }

    @RequestMapping("/")
    public String calc() {
        return "calc";

    }

}

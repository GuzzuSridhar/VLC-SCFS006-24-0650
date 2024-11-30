package com.example.arraylistcrud.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    ArrayList<String> names = new ArrayList<>();

    @RequestMapping("/list")
    public String listNames(Model model) {
        model.addAttribute("namelist", names);
        return "names";
    }

    @RequestMapping("/add")
    public String addName(String name) {
        names.add(name);
        return "redirect:/list";
    }
}

package com.example.arraylist.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/items")
    public String showItems(Model model) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Television");
        items.add("Laptop");
        items.add("Keyboard");

        model.addAttribute("x", items);
        return "items";
    }
}

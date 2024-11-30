package com.example.arraylist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping("/api-test")
    public List<String> sendApiData() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Television");
        items.add("Laptop");
        items.add("Keyboard");

        return items;
    }
}
